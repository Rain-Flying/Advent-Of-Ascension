package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class SkyStaff extends BaseStaff<Boolean> {
	public SkyStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_SKY_STAFF_CAST.get();
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.WIND_RUNE.get(), 2);
			runes.put(AoAItems.KINETIC_RUNE.get(), 2);
			runes.put(AoAItems.ENERGY_RUNE.get(), 1);
		});
	}

	@Override
	public Optional<Boolean> checkPreconditions(LivingEntity caster, ItemStack staff) {
		return Optional.ofNullable(caster.onGround() ? true : null);
	}

	@Override
	public void cast(ServerLevel level, ItemStack staff, LivingEntity caster, Boolean args) {
		caster.setSprinting(true);
		double xMotion = -Mth.sin(caster.getYRot() / 180.0F * (float)Math.PI) * Mth.cos(caster.getXRot() / 180.0F * (float)Math.PI) * 2f;
		double zMotion = Mth.cos(caster.getYRot() / 180.0F * (float)Math.PI) * Mth.cos(caster.getXRot() / 180.0F * (float)Math.PI) * 2f;
		double yMotion = caster.getDeltaMovement().y();

		if (Math.abs(xMotion) < 0.4 && Math.abs(zMotion) < 0.4) {
			yMotion += 2f;
		}
		else {
			yMotion += 0.75F;
		}

		caster.setDeltaMovement(new Vec3(xMotion, yMotion, zMotion));
		caster.hurtMarked = true;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 2));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
