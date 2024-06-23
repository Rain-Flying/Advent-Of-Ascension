package net.tslat.aoa3.client.render.entity.projectile.mob;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.mob.BaronessShotEntity;
import net.tslat.aoa3.util.ColourUtil;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class BaronessShotRenderer extends ParticleProjectileRenderer<BaronessShotEntity> {
	public BaronessShotRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(BaronessShotEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.scaleMod(0.5f)
				.colourOverride(ColourUtil.RED)
				.spawnParticles(entity.level());
	}
}