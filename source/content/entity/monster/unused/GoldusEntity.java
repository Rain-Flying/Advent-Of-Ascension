package net.tslat.aoa3.content.entity.monster.unused;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;

public class GoldusEntity extends AoAMeleeMob<GoldusEntity> {
	public GoldusEntity(EntityType<? extends GoldusEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.5f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.IRON_GOLEM_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.IRON_GOLEM_DEATH;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);

		if (!level().isClientSide) {
			Entity attacker = source.getEntity();

			if (attacker instanceof Player || attacker instanceof TamableAnimal) {
				Player pl = null;

				if (attacker instanceof TamableAnimal) {
					if (((TamableAnimal)attacker).getOwner() instanceof Player)
						pl = (Player)((TamableAnimal)attacker).getOwner();
				}
				else {
					pl = (Player)attacker;
				}
			}
		}
	}
}
