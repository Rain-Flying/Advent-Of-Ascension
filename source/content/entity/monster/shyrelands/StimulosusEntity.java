package net.tslat.aoa3.content.entity.monster.shyrelands;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;


public class StimulosusEntity extends AoAMeleeMob<StimulosusEntity> {
    public StimulosusEntity(EntityType<? extends StimulosusEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 1.78125f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_STIMULOSUS_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_STIMULO_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_STIMULO_HURT.get();
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!level().isClientSide) {
            float healthPercent = EntityUtil.getHealthPercent(this);
            EffectBuilder effect = null;

            if (healthPercent < 0.25) {
                effect = new EffectBuilder(MobEffects.DAMAGE_BOOST, 0).level(2);
            }
            else if (healthPercent < 0.50) {
                effect = new EffectBuilder(MobEffects.DAMAGE_BOOST, 0).level(3);
            }
            else if (healthPercent < 0.75) {
                effect = new EffectBuilder(MobEffects.DAMAGE_BOOST, 0).level(4);
            }

            if (effect != null)
                EntityUtil.applyPotions(this, effect);
        }
    }
}
