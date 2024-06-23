package net.tslat.aoa3.content.entity.monster.barathos;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import org.jetbrains.annotations.Nullable;


public class RamradonEntity extends AoAMeleeMob<RamradonEntity> {
	public RamradonEntity(EntityType<? extends RamradonEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 0.875f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_RAMRADON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_RAMRADON_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_RAMRADON_HURT.get();
	}

	@Override
	protected SoundEvent getStepSound(BlockPos pos, BlockState blockState) {
		return AoASounds.ENTITY_GENERIC_VERY_HEAVY_STEP.get();
	}

	@Override
	protected void onAttack(Entity target) {
		if (target instanceof LivingEntity livingTarget && EntityUtil.getHealthPercent(livingTarget) < 0.5f)
			heal(15);
	}
}
