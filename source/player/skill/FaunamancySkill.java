package net.tslat.aoa3.player.skill;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.tslat.aoa3.common.registration.AoATags;
import net.tslat.aoa3.common.registration.custom.AoASkills;
import net.tslat.aoa3.player.ServerPlayerDataManager;
import net.tslat.aoa3.util.PlayerUtil;

public class FaunamancySkill extends AoASkill.Instance {
	private static final ListenerType[] LISTENERS = new ListenerType[] {ListenerType.OUTGOING_ATTACK_AFTER};

	public FaunamancySkill(ServerPlayerDataManager plData, JsonObject jsonData) {
		super(AoASkills.FAUNAMANCY.get(), plData, jsonData);
	}

	public FaunamancySkill(CompoundTag nbtData) {
		super(AoASkills.FAUNAMANCY.get(), nbtData);
	}

	@Override
	public ListenerType[] getListenerTypes() {
		return LISTENERS;
	}

	@Override
	public void handleAfterAttacking(LivingDamageEvent.Post ev) {
		if (canGainXp(true) && isValidSacrifice(ev.getEntity(), getPlayer(), ev.getNewDamage()))
			PlayerUtil.giveTimeBasedXpToPlayer((ServerPlayer)getPlayer(), type(), (int)(ev.getEntity().getMaxHealth() / 30f * 20),  false);
	}

	public static boolean isValidSacrifice(LivingEntity target, Player attacker, float damage) {
		if (damage == 0)
			return false;

		if (target.getHealth() - damage > 0)
			return false;

		if (!attacker.getMainHandItem().is(AoATags.Items.FAUNAMANCER_TOOL))
			return false;

		return target.getDeltaMovement().lengthSqr() < 0.01;
	}
}
