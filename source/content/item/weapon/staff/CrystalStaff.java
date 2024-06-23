package net.tslat.aoa3.content.item.weapon.staff;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.common.registration.AoASounds;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.smartbrainlib.util.EntityRetrievalUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CrystalStaff extends BaseStaff<List<Player>> {
	public CrystalStaff(Item.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public SoundEvent getCastingSound() {
		return AoASounds.ITEM_CRYSTEVIA_STAFF_CAST.get();
	}

	@Override
	public Optional<List<Player>> checkPreconditions(LivingEntity caster, ItemStack staff) {
		List<Player> players = EntityRetrievalUtil.getPlayers(caster, 20, entity -> entity.getHealth() < entity.getMaxHealth() && PlayerUtil.shouldPlayerBeAffected(entity));

		return Optional.ofNullable(players.isEmpty() ? null : players);
	}

	public static Object2IntMap<Item> getDefaultRunes() {
		return Util.make(new Object2IntArrayMap<>(), runes -> {
			runes.put(AoAItems.DISTORTION_RUNE.get(), 2);
			runes.put(AoAItems.LIFE_RUNE.get(), 5);
		});
	}

	@Override
	public void cast(Level world, ItemStack staff, LivingEntity caster, List<Player> args) {
		float currentTotalHealth = 0;
		float currentMaxHealth = 0;

		for (Player pl : args) {
			currentMaxHealth += pl.getMaxHealth();
			currentTotalHealth += pl.getHealth();
		}

		float healthPerPlayer = (currentMaxHealth * (currentTotalHealth / currentMaxHealth * 1.25f)) / (float)((List<Player>)args).size();

		for (Player pl : args) {
			pl.setHealth(healthPerPlayer);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 1));
		tooltip.add(LocaleUtil.getFormattedItemDescriptionText(this, LocaleUtil.ItemDescriptionType.BENEFICIAL, 2));
		super.appendHoverText(stack, context, tooltip, flag);
	}
}
