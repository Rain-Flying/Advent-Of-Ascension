package net.tslat.aoa3.content.item.weapon.cannon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.content.entity.projectile.cannon.SmileyCannonballEntity;
import net.tslat.aoa3.content.entity.projectile.gun.BaseBullet;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlissfulBlast extends BaseCannon {
	public BlissfulBlast(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getFiringSound() {
		return AoASounds.ITEM_BIG_BLAST_FIRE.get();
	}

	@Override
	public BaseBullet createProjectileEntity(LivingEntity shooter, ItemStack gunStack, InteractionHand hand) {
		return new SmileyCannonballEntity(shooter, this, hand, 120, 0);
	}

	@Override
	protected void doImpactEffect(Entity target, LivingEntity shooter, BaseBullet bullet, Vec3 impactPos, float bulletDmgMultiplier) {
		WorldUtil.createExplosion(shooter, bullet.level(), bullet, 3f);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(LocaleUtil.Keys.EXPLODES_ON_HIT, LocaleUtil.ItemDescriptionType.BENEFICIAL));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
