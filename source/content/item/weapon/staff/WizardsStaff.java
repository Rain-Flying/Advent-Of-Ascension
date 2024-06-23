package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.effectslib.api.util.EffectBuilder;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class WizardsStaff extends BaseStaff<Object> {
	public WizardsStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_STAFF_CAST.get();
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.LIFE_RUNE.get(), 3);
			runes.put(AoAItems.POWER_RUNE.get(), 3);
			runes.put(AoAItems.DISTORTION_RUNE.get(), 3);
		});
	}

	@Override
	public void cast(Level world, ItemStack staff, LivingEntity caster, Object args) {
		EntityUtil.applyPotions(caster,
				new EffectBuilder(MobEffects.MOVEMENT_SPEED, 200),
				new EffectBuilder(MobEffects.DAMAGE_BOOST, 200),
				new EffectBuilder(MobEffects.DAMAGE_RESISTANCE, 200),
				new EffectBuilder(MobEffects.JUMP, 200));
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
