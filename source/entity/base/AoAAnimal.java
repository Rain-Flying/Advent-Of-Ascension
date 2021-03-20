package net.tslat.aoa3.entity.base;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public abstract class AoAAnimal extends AnimalEntity {
	public AoAAnimal(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	protected void registerGoals() {
		goalSelector.addGoal(0, new SwimGoal(this));
		goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
		goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		goalSelector.addGoal(7, new LookRandomlyGoal(this));

		if (isBreedable()) {
			goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
			goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));

			if (getTemptItem() != null)
				goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(getTemptItem()), false));
		}
	}

	@Nullable
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		xpReward = (int)(getAttributeValue(Attributes.MAX_HEALTH) / 25f);

		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return null;
	}

	protected SoundEvent getStepSound(BlockPos pos, BlockState blockState) {
		return SoundEvents.COW_STEP;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == getTemptItem();
	}

	protected boolean isBreedable() {
		return false;
	}

	@Nullable
	protected Item getTemptItem() {
		return null;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState block) {
		if (getStepSound(pos, block) != null)
			playSound(getStepSound(pos, block), 0.55f, 1.0F);
	}

	@Nullable
	@Override
	public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity partner) {
		return null;
	}
}
