package net.tslat.aoa3.content.entity.npc.trader;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.aoa3.client.render.AoAAnimations;
import net.tslat.aoa3.common.registration.item.AoAArmour;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.content.entity.base.AoATrader;
import net.tslat.aoa3.util.WorldUtil;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.animation.AnimatableManager;


public class SkillMasterEntity extends AoATrader {
	private static final EntityDataAccessor<Boolean> TRADING = SynchedEntityData.defineId(SkillMasterEntity.class, EntityDataSerializers.BOOLEAN);

	private boolean trading = false;

	private static final Int2ObjectMap<VillagerTrades.ItemListing[]> TRADES = new TradeListBuilder()
			.trades(1,
					BuildableTrade.forItem(AoAItems.SMALL_SKILL_CRYSTAL).itemCost(AoAItems.ARCHAIC_TOKEN, 11).xp(20).stock(32),
					BuildableTrade.forItem(AoAItems.MEDIUM_SKILL_CRYSTAL).itemCost(AoAItems.ARCHAIC_TOKEN, 13).xp(50).stock(24),
					BuildableTrade.forItem(AoAItems.LARGE_SKILL_CRYSTAL).itemCost(AoAItems.ARCHAIC_TOKEN, 18).xp(75).stock(16),
					BuildableTrade.forItem(AoAItems.GIANT_SKILL_CRYSTAL).itemCost(AoAItems.ARCHAIC_TOKEN, 32).xp(125).stock(12),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_DEXTROUS).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_DRYAD).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_RITUALIST).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_TRAWLER).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_TREASURER).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE),
					BuildableTrade.forItem(AoAArmour.HELM_OF_THE_WARRIOR).itemCost(AoAItems.ARCHAIC_TOKEN, 64).xp(200).stock(Integer.MAX_VALUE)).build();

	public SkillMasterEntity(EntityType<? extends AoATrader> entityType, Level world) {
		super(entityType, world);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);

		builder.define(TRADING, false);
	}

	@Override
	public int getMaxTradesToUnlock(int newProfessionLevel) {
		return 50;
	}

	@Nullable
	@Override
	public Int2ObjectMap<VillagerTrades.ItemListing[]> getTradesMap() {
		return TRADES;
	}

	@Override
	public boolean requiresCustomPersistence() {
		return super.requiresCustomPersistence() || WorldUtil.isWorld(level(), AoADimensions.NOWHERE);
	}

	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		return super.isInvulnerableTo(source) || (WorldUtil.isWorld(level(), AoADimensions.NOWHERE) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY));
	}

	@Override
	public void setTradingPlayer(@Nullable Player player) {
		super.setTradingPlayer(player);

		this.trading = isTrading();
		getEntityData().set(TRADING, this.trading);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		super.onSyncedDataUpdated(key);

		if (key.equals(TRADING) && level().isClientSide()) {
			this.trading = getEntityData().get(TRADING);
		}
	}

	@Override
	public boolean isPushable() {
		return !WorldUtil.isWorld(level(), AoADimensions.NOWHERE) && super.isPushable();
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				DefaultAnimations.genericIdleController(this),
				AoAAnimations.genericHeldPoseController(this, AoAAnimations.INTERACT, AoAAnimations.INTERACT_END, entity -> this.trading));
	}
}
