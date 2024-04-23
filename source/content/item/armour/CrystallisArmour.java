package net.tslat.aoa3.content.item.armour;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class CrystallisArmour extends AdventArmour {
	public CrystallisArmour(ArmorItem.Type slot) {
		super(ItemUtil.customArmourMaterial("aoa3:crystallis", 56, new int[] {5, 6, 10, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 5), slot);
	}

	@Override
	public Type getSetType() {
		return Type.CRYSTALLIS;
	}

	@Override
	public void onPostAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingDamageEvent event) {
		if (event.getSource().getEntity() instanceof LivingEntity attacker) {
			if (slots == null && (DamageUtil.isMeleeDamage(event.getSource()) || DamageUtil.isRangedDamage(event.getSource()))) {
				attacker.hurt(attacker.level().damageSources().thorns(plData.player()), event.getAmount());
				plData.player().hurtArmor(attacker.level().damageSources().generic(), event.getAmount() * 2);
			}
			else if (slots != null && plData.equipment().getCurrentFullArmourSet() != getSetType() && DamageUtil.isMeleeDamage(event.getSource())) {
				attacker.hurt(attacker.level().damageSources().thorns(plData.player()), event.getAmount() * slots.size() / 4f);
				plData.player().hurtArmor(attacker.level().damageSources().generic(), event.getAmount() * 2);
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.crystallis_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.crystallis_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.crystallis_armour.desc.3", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
