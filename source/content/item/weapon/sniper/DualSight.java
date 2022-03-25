package net.tslat.aoa3.content.item.weapon.sniper;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.tslat.aoa3.common.registration.AoASounds;

import javax.annotation.Nullable;

public class DualSight extends BaseSniper {
	public DualSight(double dmg, int durability, int firingDelayTicks, float recoil) {
		super(dmg, durability, firingDelayTicks, recoil);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_SNIPER_MEDIUM_FIRE_LONG.get();
	}

	@Override
	public ResourceLocation getScopeTexture(ItemStack stack) {
		return SCOPE_4;
	}
}