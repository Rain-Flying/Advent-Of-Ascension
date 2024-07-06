package net.tslat.aoa3.content.item.armour;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.tslat.aoa3.common.registration.item.AoAArmourMaterials;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.LocaleUtil;

import java.util.EnumSet;
import java.util.List;

public class InfernalArmour extends AdventArmour {
	public InfernalArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.INFERNAL, slot, 39);
	}

	@Override
	public void handleIncomingDamage(LivingEntity entity, EnumSet<Piece> equippedPieces, LivingIncomingDamageEvent ev) {
		if (ev.getSource().is(DamageTypeTags.IS_FIRE))
			ev.addReductionModifier(DamageContainer.Reduction.ARMOR, (container, reduction) -> DamageUtil.percentDamageReduction(container, reduction, perPieceValue(equippedPieces, 0.15f)));
	}

	@Override
	public void checkDamageInvulnerability(LivingEntity entity, EnumSet<Piece> equippedPieces, EntityInvulnerabilityCheckEvent ev) {
		if (ev.getSource().is(DamageTypeTags.IS_FIRE) && equippedPieces.contains(Piece.FULL_SET))
			ev.setInvulnerable(true);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.infernal_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.infernal_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
