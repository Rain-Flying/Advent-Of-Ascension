/*
package net.tslat.aoa3.content.entity.mob.gardencia;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

import net.tslat.aoa3.content.entity.base.AoAMeleeMob;
import net.tslat.aoa3.content.entity.boss.VinocorneEntity;
import net.tslat.effectslib.api.util.EffectBuilder;
import net.tslat.aoa3.util.EntityUtil;

public class YellowFlowerEntity extends AoAMeleeMob<YellowFlowerEntity> {
	public YellowFlowerEntity(VinocorneEntity vinocorne) {
		this(AoAMobs.YELLOW_FLOWER.get(), vinocorne.level);

		moveTo(vinocorne.getX(), vinocorne.getY(), vinocorne.getZ(), random.nextFloat() * 360, 0);
	}

	public YellowFlowerEntity(EntityType<? extends YellowFlowerEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	public float getEyeHeightAccess(Pose pose) {
		return 1.5f;
	}

	@Override
	public void tick() {
		super.tick();

		if (random.nextInt(100) == 0)
			EntityUtil.applyPotions(this, new EffectBuilder(MobEffects.INVISIBILITY, 35));
	}
}
*/
