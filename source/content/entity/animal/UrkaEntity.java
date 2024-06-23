package net.tslat.aoa3.content.entity.animal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAAnimalOld;
import org.jetbrains.annotations.Nullable;


public class UrkaEntity extends AoAAnimalOld {
	public UrkaEntity(EntityType<? extends Animal> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return getDimensions(pose).height() * 0.85f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_URKA_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_URKA_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_URKA_HURT.get();
	}

	@Override
	public float getWalkTargetValue(BlockPos pos, LevelReader world) {
		return world.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK) ? 10 : 15 - world.getMaxLocalRawBrightness(pos) - 0.5F;
	}

	@Override
	protected boolean isBreedable() {
		return false;
	}
}
