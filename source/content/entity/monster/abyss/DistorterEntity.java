package net.tslat.aoa3.content.entity.monster.abyss;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;


public class DistorterEntity extends AoAMeleeMob<DistorterEntity> {
	private int effectTick = 60;

	public DistorterEntity(EntityType<? extends DistorterEntity> entityType, Level world) {
		super(entityType, world);
	}

	/*@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 15f));
		goalSelector.addGoal(2, new RandomLookAroundGoal(this));
	}*/

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.675f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_DISTORTER_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_DISTORTER_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_DISTORTER_HURT.get();
	}

	@Override
	public void aiStep() {
		super.aiStep();

		effectTick--;

		if (tickCount % 5 == 0) {
			Holder<MobEffect> currentEffect = effectTick <= 30 ? MobEffects.MOVEMENT_SLOWDOWN : MobEffects.MOVEMENT_SPEED;

			for (Player pl : level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(2), pl -> pl != null && !pl.isSpectator() && !pl.isCreative() && hasLineOfSight(pl))) {
				EntityUtil.applyPotions(pl, new EffectBuilder(currentEffect, 5).level(6).hideParticles()); // TODO custom effect?
			}
		}

		if (effectTick <= 0)
			effectTick = 60;
	}
}
