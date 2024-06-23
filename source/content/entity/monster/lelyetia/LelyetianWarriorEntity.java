package net.tslat.aoa3.content.entity.monster.lelyetia;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.util.ItemUtil;
import org.jetbrains.annotations.Nullable;


public class LelyetianWarriorEntity extends AoAMeleeMob<LelyetianWarriorEntity> {
	public LelyetianWarriorEntity(EntityType<? extends LelyetianWarriorEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.75f;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return AoASounds.ENTITY_LELYETIAN_AMBIENT.get();
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return AoASounds.ENTITY_LELYETIAN_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return AoASounds.ENTITY_LELYETIAN_HURT.get();
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);

		if (!level().isClientSide() && source.getMsgId().equals("fireworks") && source.getEntity() instanceof Player && ItemUtil.findInventoryItem((Player)source.getEntity(), new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
			ItemUtil.givePlayerItemOrDrop((Player)source.getEntity(), new ItemStack(AoAItems.CELEVE_REALMSTONE.get()));
	}
}
