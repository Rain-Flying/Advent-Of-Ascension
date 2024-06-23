package net.tslat.aoa3.client.render.entity.projectile.mob;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.mob.HagShotEntity;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class HagShotRenderer extends ParticleProjectileRenderer<HagShotEntity> {
	public HagShotRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(HagShotEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.colourOverride(0, entity.level().random.nextFloat() * 0.7f + 0.3f, 0, 1f)
				.spawnParticles(entity.level());
	}
}