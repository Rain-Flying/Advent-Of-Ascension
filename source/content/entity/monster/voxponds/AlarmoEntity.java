package net.tslat.aoa3.content.entity.monster.voxponds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AlarmoEntity extends AoAMeleeMob<AlarmoEntity> {
    public AlarmoEntity(EntityType<? extends AlarmoEntity> entityType, Level world) {
        super(entityType, world);
    }

    /*@Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8f));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }*/

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 1f;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AoASounds.ENTITY_ALARMO_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_ALARMO_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_ALARMO_HURT.get();
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (level().isClientSide || isNoAi())
            return;

        List<Player> playerList = level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(4), pl -> pl != null && !pl.isSpectator() && !pl.isCreative() && hasLineOfSight(pl));

        if (!playerList.isEmpty()) {
            List<LivingEntity> mobList = level().getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(30), EntityUtil::isHostileMob);

            EntityUtil.applyPotions(this, new EffectBuilder(MobEffects.MOVEMENT_SLOWDOWN, 0).level(20));

            for (LivingEntity mob : mobList) {
                mob.setLastHurtByMob(playerList.get(rand().nextInt(playerList.size())));
            }
        }
    }
}
