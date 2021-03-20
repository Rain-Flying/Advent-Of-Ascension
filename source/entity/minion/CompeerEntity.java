package net.tslat.aoa3.entity.minion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.PotionUtil;

import javax.annotation.Nullable;

public class CompeerEntity extends AoAMinion {
	public CompeerEntity(EntityType<? extends TameableEntity> entityType, final World world){
		super(entityType, world);
	}

	@Override
	protected float getStandingEyeHeight(Pose pose, EntitySize size) {
		return 1.09375f;
	}

	@Override
	protected boolean isHostile() {
		return true;
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		if (super.doHurtTarget(entity)) {
			EntityUtil.applyPotions(entity, new PotionUtil.EffectBuilder(Effects.MOVEMENT_SLOWDOWN, 40).level(2));

			return true;
		}
		else {
			return false;
		}
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_COMPEER_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_COMPEER_HURT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_COMPEER_DEATH.get();
	}
}
