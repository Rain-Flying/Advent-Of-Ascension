package net.tslat.aoa3.item.minionslab;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.tslat.aoa3.common.registration.AoAEntities;
import net.tslat.aoa3.entity.minion.AoAMinion;
import net.tslat.aoa3.entity.minion.ConstructOfServilityEntity;

public class ConstructOfServilitySlab extends BaseSlab {
	public ConstructOfServilitySlab() {
		super(83, 180, 83, 3000);
	}

	@Override
	public AoAMinion activateSlab(PlayerEntity pl, ItemStack stack) {
		ConstructOfServilityEntity constructOfServility = new ConstructOfServilityEntity(AoAEntities.Minions.CONSTRUCT_OF_SERVILITY.get(), pl.level);

		constructOfServility.teleportTo(pl.getX(), pl.getY(), pl.getZ());
		constructOfServility.tame(pl);
		pl.level.addFreshEntity(constructOfServility);

		return constructOfServility;
	}
}
