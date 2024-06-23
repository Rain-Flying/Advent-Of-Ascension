package net.tslat.aoa3.content.entity.npc.ambient;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.content.entity.base.AoAAmbientNPC;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;


public class GorbCitizenEntity extends AoAAmbientNPC {
	public GorbCitizenEntity(EntityType<? extends PathfinderMob> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.5f;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return !WorldUtil.isWorld(level(), AoADimensions.MYSTERIUM);
	}

	@Nullable
	@Override
	protected String getInteractMessage(ItemStack heldItem) {
		return LocaleUtil.createDialogueLocaleKey("gorb_citizen." + random.nextInt(5));
	}
}
