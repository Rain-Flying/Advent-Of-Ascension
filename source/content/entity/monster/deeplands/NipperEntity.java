package net.tslat.aoa3.content.entity.monster.deeplands;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.animation.AnimatableManager;


public class NipperEntity extends AoAMeleeMob<NipperEntity> {
    public NipperEntity(EntityType<? extends NipperEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 7.5f / 16f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_NIPPER_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_NIPPER_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_NIPPER_HURT.get();
    }

    @Override
    protected int getAttackSwingDuration() {
        return 6;
    }

    @Override
    protected int getPreAttackTime() {
        return 2;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                DefaultAnimations.genericWalkController(this),
                AoAAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_BITE));
    }
}
