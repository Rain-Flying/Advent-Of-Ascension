package net.tslat.aoa3.library.advancement.trigger;

import com.google.gson.JsonObject;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.tslat.aoa3.util.constant.Skills;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.advancements.ICriterionTrigger.Listener;

public class AoALevelUpTrigger implements ICriterionTrigger<AoALevelUpTrigger.Instance> {
	private static final ResourceLocation triggerId = new ResourceLocation("aoa3", "level_up");
	private final HashMap<PlayerAdvancements, Listeners> listeners = new HashMap<PlayerAdvancements, Listeners>();

	@Override
	public ResourceLocation getId() {
		return triggerId;
	}

	@Override
	public void addPlayerListener(PlayerAdvancements playerAdvancements, Listener<Instance> listener) {
		Listeners playerListeners = this.listeners.get(playerAdvancements);

		if (playerListeners == null)
			this.listeners.put(playerAdvancements, (playerListeners = new Listeners(playerAdvancements)));

		playerListeners.add(listener);
	}

	@Override
	public void removePlayerListener(PlayerAdvancements playerAdvancements, Listener<Instance> listener) {
		Listeners playerListeners = this.listeners.get(playerAdvancements);

		if (playerListeners != null) {
			playerListeners.remove(listener);

			if (playerListeners.isEmpty())
				this.listeners.remove(playerAdvancements);
		}
	}

	@Override
	public void removePlayerListeners(PlayerAdvancements playerAdvancements) {
		this.listeners.remove(playerAdvancements);
	}

	@Override
	public Instance createInstance(JsonObject json, ConditionArrayParser conditions) {
		Skills skill = json.has("skill") ? Skills.valueOf(JSONUtils.getAsString(json, "skill").toUpperCase()) : null;
		int lvl = json.has("level") ? MathHelper.clamp(JSONUtils.getAsInt(json, "level"), 1, 1000) : 0;

		return new AoALevelUpTrigger.Instance(skill, lvl);
	}

	public void trigger(ServerPlayerEntity player, Skills skill, int level) {
		Listeners playerListeners = this.listeners.get(player.getAdvancements());

		if (playerListeners != null)
			playerListeners.trigger(skill, level);
	}

	public static class Instance extends CriterionInstance {
		@Nullable
		private final Skills skill;
		private final int level;

		public Instance(@Nullable Skills skill, int lvl, EntityPredicate.AndPredicate playerPredicate) {
			super(triggerId, playerPredicate);

			this.skill = skill;
			this.level = MathHelper.clamp(lvl, 1, 1000);
		}

		public Instance(@Nullable Skills skill, int lvl) {
			this(skill, lvl, EntityPredicate.AndPredicate.ANY);
		}

		@Override
		public JsonObject serializeToJson(ConditionArraySerializer conditions) {
			JsonObject obj = new JsonObject();

			if (skill != null)
				obj.addProperty("skill", skill.toString().toLowerCase());

			if (level > 0)
				obj.addProperty("level", level);

			return obj;
		}

		public boolean test(Skills skill, int level) {
			return (this.skill == null || this.skill == skill) && (this.level == 0 || level >= this.level);
		}
	}

	static class Listeners {
		private final PlayerAdvancements advancements;
		private final HashSet<Listener<Instance>> listeners = new HashSet<Listener<Instance>>();

		public Listeners(PlayerAdvancements playerAdvancements) {
			this.advancements = playerAdvancements;
		}

		public boolean isEmpty() {
			return this.listeners.isEmpty();
		}

		public void add(Listener<AoALevelUpTrigger.Instance> listener) {
			this.listeners.add(listener);
		}

		public void remove(Listener<AoALevelUpTrigger.Instance> listener) {
			this.listeners.remove(listener);
		}

		public void trigger(Skills skill, int lvl) {
			ArrayList<Listener<Instance>> list = null;

			for (Listener<Instance> listener : this.listeners) {
				if (listener.getTriggerInstance().test(skill, lvl)) {
					if (list == null)
						list = new ArrayList<Listener<Instance>>();

					list.add(listener);
				}
			}

			if (list != null) {
				for (Listener<Instance> listener : list) {
					listener.run(this.advancements);
				}
			}
		}
	}
}
