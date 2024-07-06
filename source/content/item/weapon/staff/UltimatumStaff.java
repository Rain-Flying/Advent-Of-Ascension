package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.projectile.staff.BaseEnergyShot;
import net.tslat.aoa3.content.entity.projectile.staff.UltimatumShotEntity;
import net.tslat.aoa3.scheduling.AoAScheduler;
import net.tslat.aoa3.scheduling.sync.UltimatumStaffTask;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UltimatumStaff extends BaseStaff<Object> {
	public UltimatumStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_ULTIMATUM_STAFF_CAST.get();
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.LIFE_RUNE.get(), 5);
			runes.put(AoAItems.POWER_RUNE.get(), 3);
			runes.put(AoAItems.DISTORTION_RUNE.get(), 8);
		});
	}

	@Override
	public void cast(ServerLevel level, ItemStack staff, LivingEntity caster, Object args) {
		level.addFreshEntity(new UltimatumShotEntity(caster, this, 60));
	}

	@Override
	public boolean doEntityImpact(BaseEnergyShot shot, Entity target, LivingEntity shooter) {
		if (target instanceof LivingEntity && !EntityUtil.isImmuneToSpecialAttacks(target)) {
			Vec3 lookVec = shooter.getLookAngle();

			double posX = shooter.getX() + lookVec.x * 4;
			double posZ = shooter.getZ() + lookVec.z * 4;

			target.absMoveTo(posX, shooter.getY(), posZ, (shooter.yHeadRot + 180) % 360, 0);
			target.setYHeadRot((shooter.yHeadRot + 180) % 360);
			target.teleportTo(posX, shooter.getY(), posZ);
			AoAScheduler.scheduleSyncronisedTask(new UltimatumStaffTask(shooter, (LivingEntity)target), 2);

			return true;
		}

		return false;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.UNIQUE, 1));
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.SPEC_IMMUNE, LocaleUtil.ItemDescriptionType.HARMFUL));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
