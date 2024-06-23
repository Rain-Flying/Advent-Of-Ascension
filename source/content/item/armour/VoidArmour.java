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

public class VoidArmour extends AdventArmour {
	public VoidArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.VOID, slot, 25);
	}

	@Override
	public Type getSetType() {
		return Type.VOID;
	}

	@Override
	public void onPostAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingDamageEvent event) {
		if (slots == null || plData.equipment().getCurrentFullArmourSet() != getSetType()) {
			if (!plData.player().level().isClientSide && event.getSource().getEntity() instanceof LivingEntity) {
				LivingEntity attacker = (LivingEntity)event.getSource().getEntity();

				if (DamageUtil.isMeleeDamage(event.getSource())) {
					if (slots == null) {
						if (RandomUtil.oneInNChance(5))
							attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 20, true, true));
					}
					else {
						if (RandomUtil.percentChance(0.025f * slots.size()))
							attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 20, true, true));
					}
				}
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.void_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.void_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
