package net.tslat.aoa3.content.item.armour;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
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
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class ExoplateArmour extends AdventArmour {
	public ExoplateArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.EXOPLATE, slot, 46);
	}

	@Override
	public Type getSetType() {
		return Type.EXOPLATE;
	}

	@Override
	public void onAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingHurtEvent event) {
		if (slots != null && !DamageUtil.isEnvironmentalDamage(event.getSource())) {
			LivingEntity entity = event.getEntity();
			BlockPos playerPos = entity.blockPosition();
			int lightLvl = Mth.clamp(2 + WorldUtil.getLightLevel((ServerLevel)entity.level(), playerPos, false, false), 2, 15);

			event.setAmount(event.getAmount() * (1 - (1 - (lightLvl / 15f)) * 0.0625f * slots.size()));
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.exoplate_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
