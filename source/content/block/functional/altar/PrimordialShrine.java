package net.tslat.aoa3.content.block.functional.altar;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import net.tslat.aoa3.common.registration.worldgen.AoADimensions;
import net.tslat.aoa3.content.block.functional.misc.DustopianLamp;
import net.tslat.aoa3.util.LocaleUtil;
import net.tslat.aoa3.util.PlayerUtil;
import net.tslat.aoa3.util.WorldUtil;
import net.tslat.smartbrainlib.util.RandomUtil;

public class PrimordialShrine extends BossAltarBlock {
	public PrimordialShrine(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (level.getDifficulty() == Difficulty.PEACEFUL && player instanceof ServerPlayer) {
			PlayerUtil.notifyPlayer(player, Component.translatable(LocaleUtil.createFeedbackLocaleKey("spawnBoss.difficultyFail")));

			return InteractionResult.FAIL;
		}

		if (!level.isClientSide && checkActivationConditions(player, InteractionHand.MAIN_HAND, state, pos))
			doActivationEffect(player, InteractionHand.MAIN_HAND, state, pos);

		return InteractionResult.SUCCESS;
	}

	@Override
	protected boolean checkActivationConditions(Player player, InteractionHand hand, BlockState state, BlockPos pos) {
		if (!WorldUtil.isWorld(player.level(), AoADimensions.DUSTOPIA))
			return false;

		return checkLamps(player.level(),
				pos.offset(5, 1, -3),
				pos.offset(4, 1, -1),
				pos.offset(3, 3, 1),
				pos.offset(1, 5, 1),
				pos.offset(-1, 5, 1),
				pos.offset(-3, 3, 1),
				pos.offset(-4, 1, -1),
				pos.offset(-5, 1, -3));
	}

	private boolean checkLamps(Level world, BlockPos... positions) {
		for (BlockPos pos : positions) {
			BlockState state = world.getBlockState(pos);

			if (state.getBlock() != AoABlocks.DUSTOPIAN_LAMP.get() || !state.getValue(DustopianLamp.LIT))
				return false;
		}

		return true;
	}

	@Override
	protected void doActivationEffect(Player player, InteractionHand hand, BlockState state, BlockPos blockPos) {
		Level world = player.level();
		BlockState lampOff = AoABlocks.DUSTOPIAN_LAMP.get().defaultBlockState().setValue(DustopianLamp.LIT, false);

		world.setBlockAndUpdate(RandomUtil.getRandomSelection(
				blockPos.offset(5, 1, -3),
				blockPos.offset(4, 1, -1),
				blockPos.offset(3, 3, 1),
				blockPos.offset(1, 5, 1),
				blockPos.offset(-1, 5, 1),
				blockPos.offset(-3, 3, 1),
				blockPos.offset(-4, 1, -1),
				blockPos.offset(-5, 1, -3)), lampOff);

		/*KajarosEntity kajaros = new KajarosEntity(AoAMobs.KAJAROS.get(), player.level);

		kajaros.moveTo(blockPos.getX(), blockPos.getY() + 3, blockPos.getZ(), 0, 0);
		player.level.addFreshEntity(kajaros);
		sendSpawnMessage(player, LocaleUtil.getLocaleMessage(AoAMobs.OKAZOR.get().getDescriptionId() + ".spawn", player.getDisplayName()), blockPos);*/
	}

	@Override
	protected Item getActivationItem() {
		return null;
	}
}