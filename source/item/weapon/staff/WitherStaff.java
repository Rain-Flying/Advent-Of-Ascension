package net.tslat.aoa3.item.weapon.staff;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.AoAItems;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.entity.projectile.staff.BaseEnergyShot;
import net.tslat.aoa3.entity.projectile.staff.WitherShotEntity;
import net.tslat.aoa3.item.misc.RuneItem;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PotionUtil;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class WitherStaff extends BaseStaff<Object> {
	public WitherStaff(int durability) {
		super(durability);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_STAFF_CAST.get();
	}

	@Override
	protected void populateRunes(HashMap<RuneItem, Integer> runes) {
		runes.put(AoAItems.WIND_RUNE.get(), 2);
		runes.put(AoAItems.WITHER_RUNE.get(), 2);
	}

	@Override
	public void cast(World world, ItemStack staff, LivingEntity caster, Object args) {
		world.addFreshEntity(new WitherShotEntity(caster, this, 60));
	}

	@Override
	public boolean doEntityImpact(BaseEnergyShot shot, Entity target, LivingEntity shooter) {
		if (DamageUtil.dealMagicDamage(shot, shooter, target, getDmg(), false)) {
			EntityUtil.applyPotions(target, new PotionUtil.EffectBuilder(Effects.WITHER, 60).level(4));

			return true;
		}

		return false;
	}

	@Override
	public float getDmg() {
		return 5;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, world, tooltip, flag);
	}
}
