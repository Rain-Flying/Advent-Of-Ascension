package net.tslat.aoa3.content.entity.monster.greckon;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;


public class HunterEntity extends AoAMeleeMob<HunterEntity> {
    public HunterEntity(EntityType<? extends HunterEntity> entityType, Level world) {
        super(entityType, world);

        setSpeed(2.7f);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 0.875f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_HUNTER_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_HUNTER_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_HUNTER_HURT.get();
    }
}
