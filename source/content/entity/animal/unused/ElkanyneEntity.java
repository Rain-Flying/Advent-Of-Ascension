package net.tslat.aoa3.content.entity.animal.unused;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.tslat.aoa3.content.entity.base.AoAAnimalOld;
import org.jetbrains.annotations.Nullable;


public class ElkanyneEntity extends AoAAnimalOld {
	public ElkanyneEntity(EntityType<? extends Animal> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.05f;
	}/*

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_ELKANYNE_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_ELKANYNE_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_ELKANYNE_HURT.get();
	}*/

	@Override
	protected boolean isBreedable() {
		return true;
	}

	@Nullable
	@Override
	protected Item getTemptItem() {
		return Item.byBlock(Blocks.BROWN_MUSHROOM);
	}/*

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		return new ElkanyneEntity(AoAAnimals.ELKANYNE.get(), this.level());
	}*/
}
