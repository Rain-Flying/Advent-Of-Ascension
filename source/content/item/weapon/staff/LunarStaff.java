package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.projectile.staff.BaseEnergyShot;
import net.tslat.aoa3.content.entity.projectile.staff.LunarFallEntity;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class LunarStaff extends BaseStaff<BlockPos> {
	public LunarStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_LUNAR_STAFF_CAST.get();
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.COMPASS_RUNE.get(), 1);
			runes.put(AoAItems.LUNAR_RUNE.get(), 2);
		});
	}

	@Override
	public Optional<BlockPos> checkPreconditions(LivingEntity caster, ItemStack staff) {
		return Optional.ofNullable(PlayerUtil.getBlockAimingAt(caster, 70));
	}

	@Override
	public void cast(ServerLevel level, ItemStack staff, LivingEntity caster, BlockPos args) {
		level.addFreshEntity(new LunarFallEntity(caster, this, args.getX(), args.getY() + 30, args.getZ(), 3.0f));
	}

	@Override
	public boolean doEntityImpact(BaseEnergyShot shot, Entity target, LivingEntity shooter) {
		if (DamageUtil.doMagicProjectileAttack(shooter, shot, target, getDmg())) {
			EntityUtil.applyPotions(target, new EffectBuilder(MobEffects.GLOWING, 200));

			return true;
		}

		return false;
	}

	@Override
	public float getDmg() {
		return 32;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
