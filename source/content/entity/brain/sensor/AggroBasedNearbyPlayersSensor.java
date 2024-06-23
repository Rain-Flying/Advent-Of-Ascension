package net.tslat.aoa3.content.entity.brain.sensor;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.tslat.aoa3.common.registration.AoAAttributes;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.tslat.smartbrainlib.object.SquareRadius;
import net.tslat.smartbrainlib.util.BrainUtils;
import net.tslat.smartbrainlib.util.EntityRetrievalUtil;
import net.tslat.smartbrainlib.util.SensoryUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class AggroBasedNearbyPlayersSensor<E extends LivingEntity> extends NearbyPlayersSensor<E> {
	private BiPredicate<E, Player> targetablePredicate = SensoryUtils::isEntityTargetable;
	private BiPredicate<E, Player> attackablePredicate = SensoryUtils::isEntityAttackable;

	public AggroBasedNearbyPlayersSensor<E> onlyTargeting(BiPredicate<E, Player> predicate) {
		this.targetablePredicate = predicate;

		return this;
	}

	public AggroBasedNearbyPlayersSensor<E> onlyAttacking(BiPredicate<E, Player> predicate) {
		this.attackablePredicate = predicate;

		return this;
	}

	@Override
	protected void doTick(ServerLevel level, E entity) {
		SquareRadius radius = this.radius;

		if (radius == null) {
			double dist = entity.getAttributeValue(AoAAttributes.AGGRO_RANGE);

			radius = new SquareRadius(dist, dist);
		}

		List<Player> players = EntityRetrievalUtil.getPlayers(level, radius.inflateAABB(entity.getBoundingBox()), player -> predicate().test(player, entity));

		players.sort(Comparator.comparingDouble(entity::distanceToSqr));

		List<Player> targetablePlayers = new ObjectArrayList<>(players);

		targetablePlayers.removeIf(pl -> !this.targetablePredicate.test(entity, pl));

		List<Player> attackablePlayers = new ObjectArrayList<>(targetablePlayers);

		attackablePlayers.removeIf(pl -> !this.attackablePredicate.test(entity, pl));

		BrainUtils.setMemory(entity, MemoryModuleType.NEAREST_PLAYERS, players);
		BrainUtils.setMemory(entity, MemoryModuleType.NEAREST_VISIBLE_PLAYER, targetablePlayers.isEmpty() ? null : targetablePlayers.get(0));
		BrainUtils.setMemory(entity, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, attackablePlayers.isEmpty() ? null : attackablePlayers.get(0));
	}
}
