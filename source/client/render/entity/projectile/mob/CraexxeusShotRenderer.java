package net.tslat.aoa3.client.render.entity.projectile.mob;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.entity.projectile.mob.CraexxeusShotEntity;
import net.tslat.aoa3.common.particletype.CustomisableParticleType;
import net.tslat.aoa3.util.NumberUtil;

public class CraexxeusShotRenderer extends ParticleProjectileRenderer<CraexxeusShotEntity> {
	public CraexxeusShotRenderer(final EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected void addParticles(CraexxeusShotEntity entity, float partialTicks) {
		entity.level.addParticle(new CustomisableParticleType.Data(AoAParticleTypes.SWIRLY.get(), 1, 3, NumberUtil.RGB(0, 255, 255)), entity.getX(), entity.getY(), entity.getZ(), 0, 0, 0);
		entity.level.addParticle(new CustomisableParticleType.Data(AoAParticleTypes.SWIRLY.get(), 1, 3, NumberUtil.RGB(255, 255, 0)), entity.getX(), entity.getY() + 0.25f, entity.getZ(), 0, 0, 0);
		entity.level.addParticle(new CustomisableParticleType.Data(AoAParticleTypes.SWIRLY.get(), 1, 3, NumberUtil.RGB(255, 255, 0)), entity.getX(), entity.getY() - 0.25f, entity.getZ(), 0, 0, 0);
	}
}
