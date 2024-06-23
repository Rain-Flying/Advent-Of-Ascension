package net.tslat.aoa3.content.entity.monster.crystevia;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.effectslib.api.util.EffectUtil;
import org.jetbrains.annotations.Nullable;


public class ConstructOfStrengthEntity extends AoAMeleeMob<ConstructOfStrengthEntity> {
    public ConstructOfStrengthEntity(EntityType<? extends ConstructOfStrengthEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 2.125f;
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
    public void tick() {
        super.tick();

        if (isAlive() && getHealth() < getMaxHealth())
            heal(0.1f);
    }

    @Override
    public boolean addEffect(MobEffectInstance effect, @Nullable Entity source) {
        if (effect.getEffect() == MobEffects.DAMAGE_BOOST)
            EffectUtil.amplifyEffect(effect, (effect.getAmplifier() + 1) * 4 - effect.getAmplifier());

        return super.addEffect(effect);
    }

    @Override
    protected void onAttack(Entity target) {
        if (!level().isClientSide && target instanceof Player && ((Player)target).getHealth() > 0 && hasEffect(MobEffects.DAMAGE_BOOST) && ItemUtil.findInventoryItem((Player)target, new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
            ItemUtil.givePlayerItemOrDrop((Player)target, new ItemStack(AoAItems.NOWHERE_REALMSTONE.get()));
    }
}
