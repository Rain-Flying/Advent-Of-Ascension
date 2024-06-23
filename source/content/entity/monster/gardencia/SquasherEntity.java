package net.tslat.aoa3.content.entity.monster.gardencia;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.AttributeUtil;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

public class SquasherEntity extends AoAMeleeMob<SquasherEntity> {
    private  static final AttributeModifier CANDIED_WATER_BUFF = new AttributeModifier(AdventOfAscension.id("candied_water"), 50, AttributeModifier.Operation.ADD_VALUE);
    private boolean candiedWater = false;

    public SquasherEntity(EntityType<? extends SquasherEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 1.75f;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AoASounds.ENTITY_GENERIC_PLANT_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AoASounds.ENTITY_GENERIC_PLANT_HURT.get();
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public float getJumpPower() {
        return 0.8f;
    }

    @Override
    protected void onInsideBlock(BlockState state) {
        if (state.getBlock() == AoABlocks.CANDIED_WATER.getBlock()) {
            if (!candiedWater) {
                AttributeUtil.applyTransientModifier(this, Attributes.MAX_HEALTH, CANDIED_WATER_BUFF);
                setHealth(getHealth() * 1.5f);

                candiedWater = true;
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        if (candiedWater)
            compound.putBoolean("AoACandiedWater", true);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        candiedWater = compound.contains("AoACandiedWater");
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (isAlive()) {
            if (getHealth() < getMaxHealth()) {
                if (isInWater()) {
                    heal(0.2f);
                }
                else if (level().isRainingAt(blockPosition())) {
                    heal(0.1f);
                }
            }


            if (!level().isClientSide && RandomUtil.oneInNChance(250) && getLastHurtByMob() != null)
                jumpFromGround();
        }
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);

        if (!level().isClientSide && candiedWater && source.getEntity() instanceof Player && ItemUtil.findInventoryItem((Player)source.getEntity(), new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
            ItemUtil.givePlayerItemOrDrop((Player)source.getEntity(), new ItemStack(AoAItems.LBOREAN_REALMSTONE.get()));
    }
}
