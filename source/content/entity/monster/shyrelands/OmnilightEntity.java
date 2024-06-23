package net.tslat.aoa3.content.entity.monster.shyrelands;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAFlyingRangedMob;
import net.tslat.aoa3.content.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.content.entity.projectile.mob.OmnilightShotEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.animation.AnimatableManager;


public class OmnilightEntity extends AoAFlyingRangedMob {
    public OmnilightEntity(EntityType<? extends FlyingMob> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 0.5f;
    }

    @Nullable
    @Override
    protected SoundEvent getShootSound() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_OMNILIGHT_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_OMNILIGHT_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_OMNILIGHT_HURT.get();
    }

    @Override
    protected BaseMobProjectile getNewProjectileInstance() {
       return new OmnilightShotEntity(this, BaseMobProjectile.Type.MAGIC);
    }

    @Override
    public int getAttackSwingDuration() {
        return 26;
    }

    @Override
    public int getPreAttackTime() {
        return 12;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                DefaultAnimations.genericFlyController(this),
                AoAAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_SHOOT));
    }
}
