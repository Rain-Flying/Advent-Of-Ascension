package net.tslat.aoa3.content.item.weapon.sniper;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeadHunter extends BaseSniper {
	public HeadHunter(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_GUN_SNIPER_MEDIUM_FIRE_LONG.get();
	}

	@Override
	protected void doImpactEffect(Entity target, LivingEntity shooter, BaseBullet bullet, Vec3 impactPos, float bulletDmgMultiplier) {
		if (target instanceof LivingEntity && target.level() instanceof ServerLevel serverLevel) {

			if (impactPos != null) {
				double headMinRange = (target.getBoundingBox().minY + target.getEyeHeight()) - target.getBbHeight() * 0.105f;
				double headMaxRange = headMinRange + target.getBbHeight() * 0.225f;

				if (impactPos.y > headMinRange && impactPos.y < headMaxRange) {
					ItemStack stack = shooter.getItemInHand(bullet.getHand());

					if (!stack.is(this))
						stack = getDefaultInstance();

					for (int i = 0; i < 5; i++) {
						serverLevel.sendParticles(ParticleTypes.DAMAGE_INDICATOR, impactPos.x + RandomUtil.randomValueBetween(-0.5d, 0.5d), impactPos.y + RandomUtil.randomValueBetween(-0.5d, 0.5d), impactPos.z + RandomUtil.randomValueBetween(-0.5d, 0.5d), 3, 0, 0, 0, 0);
					}

					serverLevel.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1, 1.5f);

					if (shooter.getItemInHand(InteractionHand.MAIN_HAND).getItem() != this && shooter.getItemInHand(InteractionHand.OFF_HAND).getItem() != this)
						return;

					if (shooter instanceof Player player)
						player.getCooldowns().addCooldown(this, (int)(getTicksBetweenShots(stack) / 2f));
				}
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
