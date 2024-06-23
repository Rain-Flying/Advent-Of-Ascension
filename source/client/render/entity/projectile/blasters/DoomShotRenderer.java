package net.tslat.aoa3.client.render.entity.projectile.blasters;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.blaster.DoomShotEntity;
import net.tslat.aoa3.util.ColourUtil;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class DoomShotRenderer extends ParticleProjectileRenderer<DoomShotEntity> {
	public DoomShotRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(DoomShotEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.spawnNTimes(3)
				.colourOverride(ColourUtil.BLACK)
				.spawnParticles(entity.level());
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_DUST.get(), entity.position())
				.spawnNTimes(3)
				.colourOverride(ColourUtil.BLUE)
				.spawnParticles(entity.level());
	}
}