package net.tslat.aoa3.client.render.entity.projectile.misc;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.client.render.entity.projectile.ParticleProjectileRenderer;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.content.entity.projectile.misc.SelyanSticklerStuckEntity;
import net.tslat.aoa3.util.ColourUtil;
import net.tslat.effectslib.api.particle.ParticleBuilder;

public class SelyanSticklerStuckRenderer extends ParticleProjectileRenderer<SelyanSticklerStuckEntity> {
	public SelyanSticklerStuckRenderer(final EntityRendererProvider.Context manager) {
		super(manager);
	}

	@Override
	protected void addParticles(SelyanSticklerStuckEntity entity, float partialTicks) {
		ParticleBuilder.forPositions(AoAParticleTypes.GENERIC_SWIRL.get(), entity.position())
				.spawnNTimes(7)
				.colourOverride(ColourUtil.GREEN)
				.spawnParticles(entity.level());
	}
}