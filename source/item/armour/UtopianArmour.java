package net.tslat.aoa3.item.armour;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.player.PlayerDataManager;

import javax.annotation.Nullable;
import java.util.List;

public class UtopianArmour extends AdventArmour {
	public UtopianArmour(EquipmentSlotType slot) {
		super(ItemUtil.customArmourMaterial("aoa3:utopian", 50, new int[] {3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2), slot);
	}

	@Override
	public AdventArmour.Type setType() {
		return AdventArmour.Type.UTOPIAN;
	}

	@Override
	public void addBuffs(PlayerDataManager.PlayerBuffs plBuffs, @Nullable EquipmentSlotType slot) {
		if (slot == null) {
			plBuffs.addGlobalXpModifier(0.1f);
		}
		else {
			plBuffs.addGlobalXpModifier(0.05f);
		}
	}

	@Override
	public void removeBuffs(PlayerDataManager.PlayerBuffs plBuffs, @Nullable EquipmentSlotType slot) {
		if (slot == null) {
			plBuffs.removeGlobalXpModifier(0.1f);
		}
		else {
			plBuffs.removeGlobalXpModifier(0.05f);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.utopian_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.utopian_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
