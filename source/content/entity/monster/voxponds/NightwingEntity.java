package net.tslat.aoa3.content.entity.monster.voxponds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAFlyingMeleeMob;
import org.jetbrains.annotations.Nullable;


public class NightwingEntity extends AoAFlyingMeleeMob {
    public NightwingEntity(EntityType<? extends FlyingMob> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 0.85f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_NIGHTWING_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_NIGHTWING_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_NIGHTWING_HURT.get();
    }
}
