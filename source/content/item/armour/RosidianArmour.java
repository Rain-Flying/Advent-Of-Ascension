package net.tslat.aoa3.content.item.armour;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.tslat.aoa3.common.registration.item.AoAArmourMaterials;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.DamageUtil;
import net.tslat.aoa3.util.LocaleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;

public class RosidianArmour extends AdventArmour {
	public RosidianArmour(ArmorItem.Type slot) {
		super(AoAArmourMaterials.ROSIDIAN, slot, 55);
	}

	@Override
	public Type getSetType() {
		return Type.ROSIDIAN;
	}

	@Override
	public void onPostAttackReceived(ServerPlayerDataManager plData, @Nullable HashSet<EquipmentSlot> slots, LivingDamageEvent event) {
		if (!DamageUtil.isEnvironmentalDamage(event.getSource()) && !DamageUtil.isPoisonDamage(event.getSource())) {
			if (slots == null) {
				//if (event.getAmount() >= 4)
				//	spawnRosid(plData.player());
			}
			else {
				//if (random.nextFloat() < 0.04 * slots.size())
				//	spawnRosid(plData.player());
			}
		}
	}

	/*private void spawnRosid(Player pl) {
		RosidEntity rosid = new RosidEntity(AoAEntities.Minions.ROSID.get(), pl.level);

		rosid.tame(pl);
		rosid.setPos(pl.getX(), pl.getY(), pl.getZ());
		pl.level.addFreshEntity(rosid);
	}*/ // TODO

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
		tooltip.add(pieceEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.rosidian_armour.desc.1", LocaleUtil.ItemDescriptionType.BENEFICIAL));
		tooltip.add(setEffectHeader());
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText("item.aoa3.rosidian_armour.desc.2", LocaleUtil.ItemDescriptionType.BENEFICIAL));
	}
}
