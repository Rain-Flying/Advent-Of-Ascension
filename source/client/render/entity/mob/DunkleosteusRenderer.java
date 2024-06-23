package net.tslat.aoa3.client.render.entity.mob;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.client.render.entity.AnimatedMobRenderer;
import net.tslat.aoa3.common.registration.entity.AoAMonsters;
import net.tslat.aoa3.content.entity.monster.precasia.DunkleosteusEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DunkleosteusRenderer extends AnimatedMobRenderer<DunkleosteusEntity> {
    public DunkleosteusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(AdventOfAscension.id("mob/precasia/dunkleosteus"), false), AoAMonsters.DUNKLEOSTEUS.get().getWidth() / 3f);
    }

    @Override
    protected float getDeathMaxRotation(DunkleosteusEntity animatable) {
        return 180;
    }
}
