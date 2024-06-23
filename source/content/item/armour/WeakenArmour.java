package net.tslat.aoa3.content.item.armour;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.tslat.aoa3.common.registration.item.AoAArmourMaterials;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class WeakenArmour extends AdventArmour {
	public WeakenArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.WEAKEN, slot, 44);
	}

	@Override
	public Type getSetType() {
		return Type.WEAKEN;
	}

	@Override
	public void onPostAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingDamageEvent event) {
		if (slots == null) {
			if (RandomUtil.percentChance(0.7f) && DamageUtil.isMeleeDamage(event.getSource()) && event.getSource().getEntity() instanceof LivingEntity)
				((LivingEntity)event.getSource().getEntity()).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, true, true));
		}
		else if (plData.equipment().getCurrentFullArmourSet() != getSetType()) {
			if (RandomUtil.percentChance(0.175f * slots.size()) && DamageUtil.isMeleeDamage(event.getSource()) && event.getSource().getEntity() instanceof LivingEntity)
				((LivingEntity)event.getSource().getEntity()).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, true, true));
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.weaken_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.weaken_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
