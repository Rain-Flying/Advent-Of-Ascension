package net.tslat.aoa3.client.render.entity.projectile.mob;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.mob.SpectralShotEntity;
import net.tslat.aoa3.util.ColourUtil;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class SpectralShotRenderer extends ParticleProjectileRenderer<SpectralShotEntity> {
	public SpectralShotRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(SpectralShotEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position().add(0, 0.25f, 0))
				.colourOverride(ColourUtil.WHITE)
				.spawnParticles(entity.level());
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.colourOverride(ColourUtil.CYAN)
				.spawnParticles(entity.level());
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position().subtract(0, 0.25f, 0))
				.colourOverride(ColourUtil.WHITE)
				.spawnParticles(entity.level());
	}
}