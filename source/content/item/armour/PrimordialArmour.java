package net.tslat.aoa3.content.item.armour;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.tslat.aoa3.common.registration.item.AoAArmourMaterials;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class PrimordialArmour extends AdventArmour {
	public PrimordialArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.PRIMORDIAL, slot, 62);
	}

	@Override
	public Type getSetType() {
		return Type.PRIMORDIAL;
	}

	@Override
	public void onAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingHurtEvent event) {
		if (slots == null || (DamageUtil.isMeleeDamage(event.getSource()) && plData.equipment().getCurrentFullArmourSet() != getSetType())) {
			if (event.getSource().getEntity() instanceof LivingEntity attacker && attacker.hasEffect(MobEffects.WITHER))
				event.setAmount(event.getAmount() * (1 - 0.15f * (slots == null ? 4 : slots.size())));
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.primordial_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.primordial_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.primordial_armour.desc.3", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
