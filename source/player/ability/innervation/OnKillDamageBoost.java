package net.tslat.aoa3.player.ability.innervation;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.GsonHelper;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.tslat.aoa3.common.registration.custom.AoAAbilities;
import net.tslat.aoa3.player.ability.AoAAbility;
import net.tslat.aoa3.player.skill.AoASkill;
import net.tslat.aoa3.util.NumberUtil;

public class OnKillDamageBoost extends AoAAbility.Instance {
	private static final ListenerType[] LISTENERS = new ListenerType[] {ListenerType.OUTGOING_ATTACK, ListenerType.ENTITY_KILL};

	private long boostExpiry;

	private final float modifier;
	private final int postKillDuration;

	public OnKillDamageBoost(AoASkill.Instance skill, JsonObject data) {
		super(AoAAbilities.ON_KILL_DAMAGE_BOOST.get(), skill, data);

		this.modifier = GsonHelper.getAsFloat(data, "modifier");
		this.postKillDuration = GsonHelper.getAsInt(data, "post_kill_ticks");
	}

	public OnKillDamageBoost(AoASkill.Instance skill, CompoundTag data) {
		super(AoAAbilities.ON_KILL_DAMAGE_BOOST.get(), skill, data);

		this.modifier = data.getFloat("modifier");
		this.postKillDuration = data.getInt("post_kill_ticks");
	}

	@Override
	protected void updateDescription(MutableComponent defaultDescription) {
		super.updateDescription(Component.translatable(((TranslatableContents)defaultDescription.getContents()).getKey(), NumberUtil.roundToNthDecimalPlace((modifier - 1) * 100, 2), NumberUtil.roundToNthDecimalPlace(postKillDuration / 20f, 2)));
	}

	@Override
	public ListenerType[] getListenerTypes() {
		return LISTENERS;
	}

	@Override
	public void handleOutgoingAttack(LivingIncomingDamageEvent ev) {
		if (ev.getEntity().level().getGameTime() < boostExpiry && !ev.getSource().is(DamageTypeTags.IS_EXPLOSION))
			ev.setAmount(ev.getAmount() * this.modifier);
	}

	@Override
	public void handleEntityKill(LivingDeathEvent ev) {
		this.boostExpiry = ev.getEntity().level().getGameTime() + this.postKillDuration;
	}

	@Override
	public CompoundTag getSyncData(boolean forClientSetup) {
		CompoundTag data = super.getSyncData(forClientSetup);

		if (forClientSetup) {
			data.putFloat("modifier", this.modifier);
			data.putInt("post_kill_ticks", this.postKillDuration);
		}

		return data;
	}
}
