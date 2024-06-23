package net.tslat.aoa3.content.item.weapon.thrown;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.content.entity.projectile.thrown.VulkramEntity;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Vulkram extends BaseThrownWeapon {
	public Vulkram(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return SoundEvents.WITCH_THROW;
	}

	@Override
	public BaseBullet createProjectileEntity(LivingEntity shooter, ItemStack gunStack, InteractionHand hand) {
		return new VulkramEntity(shooter, this);
	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack stack, Direction direction) {
		return new VulkramEntity(level, position.x(), position.y(), position.z());
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
