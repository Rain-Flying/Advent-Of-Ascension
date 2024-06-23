package net.tslat.aoa3.content.entity.monster.shyrelands;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AxiolightEntity extends AoAMeleeMob<AxiolightEntity> {
    public AxiolightEntity(EntityType<? extends AxiolightEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return getDimensions(pose).height() * 0.85f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_AXIOLIGHT_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_AXIOLIGHT_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_AXIOLIGHT_HURT.get();
    }

    @Override
    public void aiStep() {
        super.aiStep();

        List<Player> playerList = level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(12), PlayerUtil::shouldPlayerBeAffected);

        if (playerList.isEmpty())
            EntityUtil.applyPotions(this, new EffectBuilder(MobEffects.INVISIBILITY, 0).hideParticles());
    }
}
