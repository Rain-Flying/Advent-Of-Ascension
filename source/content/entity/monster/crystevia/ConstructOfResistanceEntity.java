package net.tslat.aoa3.content.entity.monster.crystevia;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.effectslib.api.util.EffectUtil;
import org.jetbrains.annotations.Nullable;


public class ConstructOfResistanceEntity extends AoAMeleeMob<ConstructOfResistanceEntity> {
    public ConstructOfResistanceEntity(EntityType<? extends ConstructOfResistanceEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 2f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_CRYSTAL_CONSTRUCT_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_CRYSTAL_CONSTRUCT_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_CRYSTAL_CONSTRUCT_HURT.get();
    }

    @Override
    public boolean ignoreExplosion(Explosion explosion) {
        return true;
    }

    @Override
    public boolean addEffect(MobEffectInstance effect, @Nullable Entity source) {
        if (effect.getEffect() == MobEffects.DAMAGE_RESISTANCE)
            EffectUtil.amplifyEffect(effect, 1);

        return super.addEffect(effect);
    }

    @Override
    public void tick() {
        super.tick();

        if (isAlive() && getHealth() < getMaxHealth())
            heal(0.1f);
    }
}
