package net.tslat.aoa3.content.item.weapon.gun;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.scheduling.AoAScheduler;
import net.tslat.aoa3.scheduling.async.EchoGullTask;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EchoGull extends BaseGun {
	public EchoGull(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_GENERIC_FIRE_5.get();
	}

	@Override
	protected void doImpactEffect(Entity target, LivingEntity shooter, BaseBullet bullet, Vec3 impactPos, float bulletDmgMultiplier) {
		ArrayList<Tuple<LivingEntity, Integer>> entityList = new ArrayList<Tuple<LivingEntity, Integer>>();

		for (LivingEntity entity : bullet.level().getEntitiesOfClass(LivingEntity.class, bullet.getBoundingBox().inflate(30), EntityUtil::isHostileMob)) {
			int distance = (int)entity.distanceTo(bullet);

			if (entityList.isEmpty()) {
				entityList.add(new Tuple<LivingEntity, Integer>(entity, distance));
			}
			else {
				for (int i = 0; i < entityList.size(); i++) {
					int dist = entityList.get(i).getB();

					if (dist == distance || dist > distance) {
						entityList.add(i, new Tuple<LivingEntity, Integer>(entity, distance));

						break;
					}
				}
			}
		}

		AoAScheduler.scheduleSyncronisedTask(new EchoGullTask(bullet.level(), entityList), 1);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
