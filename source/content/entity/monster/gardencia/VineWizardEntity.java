package net.tslat.aoa3.content.entity.monster.gardencia;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.tslat.aoa3.content.entity.base.AoARangedMob;
import net.tslat.aoa3.content.entity.projectile.mob.BaseMobProjectile;
import net.tslat.aoa3.content.entity.projectile.mob.VineWizardShotEntity;
import net.tslat.aoa3.util.AttributeUtil;
import net.tslat.aoa3.util.ItemUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VineWizardEntity extends AoARangedMob<VineWizardEntity> {
    private  static final AttributeModifier CANDIED_WATER_BUFF = new AttributeModifier(AdventOfAscension.id("candied_water"), 50, AttributeModifier.Operation.ADD_VALUE);
    private boolean candiedWater = false;

    public VineWizardEntity(EntityType<? extends VineWizardEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public float getEyeHeightAccess(Pose pose) {
        return 1.875f;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {}

    @Nullable
    @Override
    protected SoundEvent getShootSound() {
        return AoASounds.ENTITY_VINE_WIZARD_SHOOT.get();
    }

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float bowDamageFactor) {
        level().addFreshEntity(new VineWizardShotEntity(this, target, BaseMobProjectile.Type.MAGIC));
    }

    @Override
    protected BaseMobProjectile getNewProjectileInstance() {
        return null;
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

        if (isAlive() && getHealth() < getMaxHealth()) {
            if (isInWater()) {
                heal(0.2f);
            }
            else if (level().isRainingAt(blockPosition())) {
                heal(0.1f);
            }
        }
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);

        if (!level().isClientSide && candiedWater && source.getEntity() instanceof Player && ItemUtil.findInventoryItem((Player)source.getEntity(), new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
            ItemUtil.givePlayerItemOrDrop((Player)source.getEntity(), new ItemStack(AoAItems.LBOREAN_REALMSTONE.get()));
    }
}
