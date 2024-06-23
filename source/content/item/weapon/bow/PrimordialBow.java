package net.tslat.aoa3.content.item.weapon.bow;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.tslat.aoa3.content.entity.projectile.arrow.CustomArrowEntity;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrimordialBow extends BaseBow {
	public PrimordialBow(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void onBlockImpact(CustomArrowEntity arrow, @Nullable Entity shooter, BlockHitResult hitResult, ItemStack stack) {
		AreaEffectCloud cloud = new AreaEffectCloud(arrow.level(), arrow.getX(), arrow.getY(), arrow.getZ());

		cloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 0, false, true));
		cloud.setParticle(ParticleTypes.SMOKE);
		cloud.setRadius(2);
		cloud.setDuration(200);

		arrow.level().addFreshEntity(cloud);
	}

	@Override
	public void onEntityImpact(CustomArrowEntity arrow, @Nullable Entity shooter, EntityHitResult hitResult, ItemStack stack, float velocity) {
		AreaEffectCloud cloud = new AreaEffectCloud(arrow.level(), arrow.getX(), arrow.getY(), arrow.getZ());

		cloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 0, false, true));
		cloud.setParticle(ParticleTypes.SMOKE);
		cloud.setRadius(2);
		cloud.setDuration(200);

		arrow.level().addFreshEntity(cloud);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
