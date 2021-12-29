package net.tslat.aoa3.entity.npc.skillmaster;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.world.World;
import net.tslat.aoa3.entity.base.AoATrader;

import javax.annotation.Nullable;

public class AuguryMasterEntity extends AoATrader {
	/*private static final Int2ObjectMap<VillagerTrades.ITrade[]> TRADES = new TradeListBuilder()
			.trades(1,
					BuildableTrade.trade(AoAArmour.AUGURY_ARMOUR.helmet).cost(AoAItems.LUNAVER_COIN).xp(150).stock(5),
					BuildableTrade.trade(AoAArmour.AUGURY_ARMOUR.chestplate).cost(AoAItems.LUNAVER_COIN).xp(150).stock(5),
					BuildableTrade.trade(AoAArmour.AUGURY_ARMOUR.leggings).cost(AoAItems.LUNAVER_COIN).xp(150).stock(5),
					BuildableTrade.trade(AoAArmour.AUGURY_ARMOUR.boots).cost(AoAItems.LUNAVER_COIN).xp(150).stock(5)).build();*/ // TODO

	public AuguryMasterEntity(EntityType<? extends AoATrader> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public int getMaxTradesToUnlock(int newProfessionLevel) {
		return newProfessionLevel == 1 ? 4 : 2;
	}

	@Nullable
	@Override
	public Int2ObjectMap<VillagerTrades.ITrade[]> getTradesMap() {
		return null;//TRADES;
	}
}