package net.tslat.aoa3.player.ability.imbuing;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.tslat.aoa3.common.registration.custom.AoAAbilities;
import net.tslat.aoa3.event.custom.events.GrindstoneResultEvent;
import net.tslat.aoa3.player.ability.AoAAbility;
import net.tslat.aoa3.player.skill.AoASkill;

public class GrindstoneCursesRemoval extends AoAAbility.Instance {
	private static final ListenerType[] LISTENERS = new ListenerType[] {ListenerType.ITEM_GRINDSTONING};

	public GrindstoneCursesRemoval(AoASkill.Instance skill, JsonObject data) {
		super(AoAAbilities.GRINDSTONE_CURSES_REMOVAL.get(), skill, data);
	}

	public GrindstoneCursesRemoval(AoASkill.Instance skill, CompoundTag data) {
		super(AoAAbilities.GRINDSTONE_CURSES_REMOVAL.get(), skill, data);
	}

	@Override
	public ListenerType[] getListenerTypes() {
		return LISTENERS;
	}

	@Override
	public void handleGrindstoneModifying(GrindstoneResultEvent ev) {
		EnchantmentHelper.updateEnchantments(ev.getOutputStack(), enchants -> enchants.removeIf(enchantmentIntegerEntry -> enchantmentIntegerEntry.is(EnchantmentTags.CURSE)));
	}
}
