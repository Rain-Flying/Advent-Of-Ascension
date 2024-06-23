package net.tslat.aoa3.client.render.entity.projectile.mob;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.mob.YellowGuardianShotEntity;
import net.tslat.aoa3.util.ColourUtil;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class YellowGuardianShotRenderer extends ParticleProjectileRenderer<YellowGuardianShotEntity> {
	public YellowGuardianShotRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(YellowGuardianShotEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.colourOverride(ColourUtil.YELLOW)
				.spawnParticles(entity.level());
	}
}