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
import net.tslat.aoa3.util.EntityUtil;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class FungalArmour extends AdventArmour {
	public FungalArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.FUNGAL, slot, 50);
	}

	@Override
	public Type getSetType() {
		return Type.FUNGAL;
	}

	@Override
	public void onPostAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingDamageEvent event) {
		if (slots != null && DamageUtil.isMeleeDamage(event.getSource())) {
			if (RandomUtil.percentChance(0.2f * slots.size())) {
				if (event.getSource().getEntity() instanceof LivingEntity)
					((LivingEntity)event.getSource().getEntity()).addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1, true, true));

				if (PlayerUtil.isWearingFullSet(plData.player(), this.getSetType()) && RandomUtil.oneInNChance(4)) {
					for (LivingEntity mob : plData.player().level().getEntitiesOfClass(LivingEntity.class, plData.player().getBoundingBox().inflate(5), EntityUtil::isHostileMob)) {
						mob.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0, true, true));
					}
				}
			}
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.fungal_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.fungal_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.fungal_armour.desc.3", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
