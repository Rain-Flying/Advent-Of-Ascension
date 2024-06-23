package net.tslat.aoa3.event;

import net.minecraft.nbt.Tag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSplitEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.tslat.aoa3.common.registration.AoAConfigs;
import net.tslat.aoa3.common.registration.item.AoAItems;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.scheduling.AoAScheduler;
import net.tslat.aoa3.util.ItemUtil;
import net.tslat.aoa3.util.WorldUtil;

public final class EntityEvents {
	public static final String SPAWNED_BY_SPAWNER_TAG = "spawned_by_spawner";

	public static void preInit() {
		final IEventBus forgeBus = NeoForge.EVENT_BUS;

		forgeBus.addListener(EventPriority.NORMAL, false, EntityJoinLevelEvent.class, EntityEvents::onEntityJoinWorld);
		forgeBus.addListener(EventPriority.LOWEST, false, FinalizeSpawnEvent.class, EntityEvents::onEntitySpawn);
		forgeBus.addListener(EventPriority.LOWEST, false, MobSplitEvent.class, EntityEvents::onEntitySplit);
		forgeBus.addListener(EventPriority.NORMAL, false, ExplosionEvent.Detonate.class, EntityEvents::onEntityExploded);
		forgeBus.addListener(EventPriority.NORMAL, false, PlayerInteractEvent.EntityInteractSpecific.class, EntityEvents::onEntityInteract);
	}

	private static void onEntityInteract(final PlayerInteractEvent.EntityInteractSpecific ev) {
		if (!ev.getEntity().level().isClientSide) {
			if (ev.getTarget() instanceof Piglin piglin && piglin.getItemBySlot(EquipmentSlot.HEAD).getItem() == Items.GOLDEN_HELMET) {
				ItemStack stack = ev.getEntity().getItemInHand(ev.getHand());

				if ((stack.getItem() == Items.ENCHANTED_GOLDEN_APPLE || stack.getItem() == AoAItems.GOLD_COIN.get()) && piglin.getOffhandItem().isEmpty()) {
					piglin.addTag("BarteringForExplosiveIdol");
					piglin.setItemSlot(EquipmentSlot.OFFHAND, stack.split(1));
					piglin.setGuaranteedDrop(EquipmentSlot.OFFHAND);
					piglin.getBrain().setMemoryWithExpiry(MemoryModuleType.ADMIRING_ITEM, true, 121);
					piglin.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
					piglin.getNavigation().stop();

					AoAScheduler.scheduleSyncronisedTask(() -> {
						if (piglin != null && piglin.isAlive() && piglin.getHealth() >= piglin.getMaxHealth()) {
							ItemStack offHandItem = piglin.getItemInHand(InteractionHand.OFF_HAND);

							if (offHandItem.getItem() == Items.ENCHANTED_GOLDEN_APPLE || offHandItem.getItem() == AoAItems.GOLD_COIN.get()) {
								piglin.setItemInHand(InteractionHand.OFF_HAND, Items.GOLD_INGOT.getDefaultInstance());
								piglin.getBrain().eraseMemory(MemoryModuleType.ADMIRING_ITEM);
							}
						}
					}, 120);
				}
			}
		}
	}

	private static void onEntityJoinWorld(EntityJoinLevelEvent ev) {
		if (!ev.getLevel().isClientSide && WorldUtil.isWorld(ev.getLevel(), AoADimensions.NETHER)) {
			if (ev.getEntity() instanceof WitherBoss && ((WitherBoss)ev.getEntity()).getInvulnerableTicks() == 220) {
				for (Player pl : ev.getLevel().getEntitiesOfClass(Player.class, ev.getEntity().getBoundingBox().inflate(50))) {
					if (ItemUtil.findInventoryItem(pl, new ItemStack(AoAItems.BLANK_REALMSTONE.get()), true, 1, false))
						ItemUtil.givePlayerItemOrDrop(pl, new ItemStack(AoAItems.ABYSS_REALMSTONE.get()));
				}
			}
		}
	}

	private static void onEntitySpawn(final FinalizeSpawnEvent ev) {
		if (ev.getSpawnType() == MobSpawnType.SPAWNER)
			ev.getEntity().getPersistentData().putBoolean(SPAWNED_BY_SPAWNER_TAG, true);
	}

	private static void onEntitySplit(final MobSplitEvent ev) {
		if (ev.getParent().getPersistentData().contains(SPAWNED_BY_SPAWNER_TAG, Tag.TAG_BYTE))
			ev.getChildren().forEach(mob -> mob.getPersistentData().putBoolean(SPAWNED_BY_SPAWNER_TAG, true));
	}

	private static void onEntityExploded(final ExplosionEvent.Detonate ev) {
		if (AoAConfigs.SERVER.saveLootFromExplosions.get())
			ev.getAffectedEntities().removeIf(entity -> entity instanceof ItemEntity && entity.tickCount < 40);
	}
}
