package net.tslat.aoa3.content.entity.monster.shyrelands;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.content.item.misc.ReservedItem;
import org.jetbrains.annotations.Nullable;

public class ArcwormEntity extends AoAMeleeMob<ArcwormEntity> {

	public ArcwormEntity(EntityType<? extends ArcwormEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 0.65625f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_ARCWORM_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_ARCWORM_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_ARCWORM_HURT.get();
	}

	@Override
	public void aiStep() {
		super.aiStep();

		ReservedItem.handleArcworm(this);
	}

}
