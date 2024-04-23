package net.tslat.aoa3.player.ability.extraction;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.tslat.aoa3.common.registration.custom.AoAAbilities;
import net.tslat.aoa3.event.custom.events.RetrieveSmeltedItemEvent;
import net.tslat.aoa3.player.ability.generic.ScalableModAbility;
import net.tslat.aoa3.player.skill.AoASkill;

import java.util.Random;

public class BonusSmeltResult extends ScalableModAbility {
	private static final ListenerType[] LISTENERS = new ListenerType[] {ListenerType.ITEM_SMELTING};

	private final Random random = new Random();
	private final int uniqueIdHash;

	public BonusSmeltResult(AoASkill.Instance skill, JsonObject data) {
		super(AoAAbilities.BONUS_SMELT_RESULT.get(), skill, data);

		this.uniqueIdHash = this.getUniqueIdentifier().hashCode();
	}

	public BonusSmeltResult(AoASkill.Instance skill, CompoundTag data) {
		super(AoAAbilities.BONUS_SMELT_RESULT.get(), skill, data);

		this.uniqueIdHash = this.getUniqueIdentifier().hashCode();
	}

	@Override
	public ListenerType[] getListenerTypes() {
		return LISTENERS;
	}

	@Override
	public void handleItemSmelting(RetrieveSmeltedItemEvent ev) {
		ItemStack smeltedStack = ev.getOutputStack();

		if (smeltedStack.getItem().getFoodProperties() == null) {
			random.setSeed(this.uniqueIdHash * ev.getEntity().level().getGameTime() >> 4);
			random.setSeed(random.nextLong());
			random.setSeed(random.nextLong());

			if (random.nextFloat() < getScaledValue())
				smeltedStack.setCount(smeltedStack.getCount() + 1);
		}
	}
}
