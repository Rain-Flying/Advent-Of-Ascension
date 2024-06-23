package net.tslat.aoa3.content.item.weapon.bow;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.EntityHitResult;
import net.tslat.aoa3.content.entity.projectile.arrow.CustomArrowEntity;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScreamerBow extends BaseBow {
	public ScreamerBow(Item.Properties properties) {
		super(properties);
	}

	@Override
	public float getArrowDamage(CustomArrowEntity arrow, @Nullable Entity shooter, EntityHitResult hitResult, ItemStack stack, float baseDamage, float velocity, boolean isCritical) {
		float damageModifier = 1 + ((float)Math.min(arrow.getDeltaMovement().y(), 0) / -9f);

		return super.getArrowDamage(arrow, shooter, hitResult, stack, baseDamage, velocity, isCritical) * damageModifier;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}