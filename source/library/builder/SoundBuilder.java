package net.tslat.aoa3.library.builder;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.PlayLevelSoundEvent;
import net.tslat.aoa3.client.ClientOperations;
import net.tslat.aoa3.common.networking.AoANetworking;
import net.tslat.aoa3.common.networking.packets.AoASoundBuilderPacket;
import net.tslat.aoa3.common.registration.AoARegistries;
import net.tslat.aoa3.util.RegistryUtil;
import net.tslat.smartbrainlib.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public final class SoundBuilder {
	public static final StreamCodec<RegistryFriendlyByteBuf, SoundBuilder> STREAM_CODEC = StreamCodec.of(SoundBuilder::toNetwork, SoundBuilder::fromNetwork);

	private SoundEvent sound;
	private SoundSource category = SoundSource.MASTER;
	private Level level = null;
	private Vec3 location = null;

	private long seed = 0L;

	private Entity followingEntity = null;

	private Vec3 velocity = null;

	private float pitch = 1f;
	private float radius = 16f;

	private int scheduleDelay = 0;
	private boolean applyTimeDilation = false;

	private boolean inWorld = true;
	private boolean loop = false;
	private int loopDelay = 0;

	private Set<Player> playTo = null;
	private Set<Player> exclude = null;

	private boolean stopSound = false;

	public SoundBuilder(Holder<SoundEvent> sound) {
		this.sound = sound.value();
	}

	public SoundBuilder(SoundEvent sound) {
		this.sound = sound;
	}

	public SoundBuilder atEntity(Entity entity) {
		this.location = entity.position();
		this.level = entity.level();

		return this;
	}

	public SoundBuilder atBlock(Level level, BlockPos pos) {
		return atPos(level, pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d);
	}

	public SoundBuilder atPos(Level level, Vec3 pos) {
		this.level = level;
		this.location = pos;

		return this;
	}

	public SoundBuilder atPos(Level level, double x, double y, double z) {
		return atPos(level, new Vec3(x, y, z));
	}

	public SoundBuilder followEntity(Entity entity) {
		if (entity != null) {
			this.level = entity.level();
			this.followingEntity = entity;
			this.location = entity.position();
		}

		return this;
	}

	public SoundBuilder moving(Vec3 velocity) {
		this.velocity = velocity;

		return this;
	}

	public SoundBuilder radius(float radius) {
		this.radius = radius;

		return this;
	}

	public SoundBuilder pitch(float pitch) {
		this.pitch = pitch;

		return this;
	}

	public SoundBuilder varyPitch(float scale) {
		this.pitch = Math.max(0, this.pitch + (float)RandomUtil.randomScaledGaussianValue(scale));

		return this;
	}

	public SoundBuilder category(SoundSource category) {
		this.category = category;

		return this;
	}

	public SoundBuilder isMusic() {
		notInWorld();
		return category(SoundSource.MUSIC);
	}

	public SoundBuilder isRecord() {
		return category(SoundSource.RECORDS);
	}

	public SoundBuilder isWeather() {
		return category(SoundSource.WEATHER);
	}

	public SoundBuilder isBlocks() {
		return category(SoundSource.BLOCKS);
	}

	public SoundBuilder isMonster() {
		return category(SoundSource.HOSTILE);
	}

	public SoundBuilder isFriendlyMob() {
		return category(SoundSource.NEUTRAL);
	}

	public SoundBuilder isPlayer() {
		return category(SoundSource.PLAYERS);
	}

	public SoundBuilder isAmbience() {
		return category(SoundSource.AMBIENT);
	}

	public SoundBuilder isNarration() {
		return category(SoundSource.VOICE);
	}

	public SoundBuilder applyTimeDilation() {
		this.applyTimeDilation = true;

		return this;
	}

	public SoundBuilder schedule(int ticks) {
		this.scheduleDelay = ticks;

		return this;
	}

	public SoundBuilder notInWorld() {
		this.inWorld = false;

		return this;
	}

	public SoundBuilder loopSound() {
		return loopSound(0);
	}

	public SoundBuilder loopSound(int afterDelay) {
		this.loop = true;
		this.loopDelay = afterDelay;

		return this;
	}

	public SoundBuilder exclude(Player... players) {
		if (exclude == null)
			exclude = new HashSet<Player>();

		if (level == null)
			level = players[0].level();

		Collections.addAll(exclude, players);

		return this;
	}

	public SoundBuilder include(Player... players) {
		if (playTo == null)
			playTo = new ObjectOpenHashSet<>();

		if (level == null)
			level = players[0].level();

		Collections.addAll(playTo, players);

		return this;
	}

	public SoundBuilder seed(long seed) {
		this.seed = seed;

		return this;
	}

	public SoundBuilder stopSound() {
		this.stopSound = true;

		return this;
	}

	public SoundEvent getSound() {
		return this.sound;
	}

	public SoundSource getCategory() {
		return this.category;
	}

	public Vec3 getLocation() {
		return this.location;
	}

	public Entity getFollowingEntity() {
		return this.followingEntity;
	}

	public Vec3 getVelocity() {
		return this.velocity;
	}

	public float getPitch() {
		return this.pitch;
	}

	public float getRadius() {
		return this.radius;
	}

	public int getScheduledDelay() {
		return this.scheduleDelay;
	}

	public boolean getApplyTimeDilation() {
		return this.applyTimeDilation;
	}

	public boolean getIsInWorld() {
		return this.inWorld;
	}

	public boolean getIsLooping() {
		return this.loop;
	}

	public int getLoopDelay() {
		return this.loopDelay;
	}

	public long getSeed() {
		return this.seed;
	}

	public void execute() {
		if (this.stopSound) {
			stop();
		}
		else {
			play();
		}
	}

	private void play() {
		if (inWorld) {
			PlayLevelSoundEvent event = followingEntity != null ? EventHooks.onPlaySoundAtEntity(followingEntity, Holder.direct(sound), category, radius / 16f, pitch) : EventHooks.onPlaySoundAtPosition(level, location.x, location.y, location.z, Holder.direct(sound), category, radius / 16f, pitch);

			if (event.isCanceled() || event.getSound() == null)
				return;

			this.sound = event.getSound().value();
		}

		if (this.level instanceof ServerLevel serverLevel) {
			final AoASoundBuilderPacket packet = new AoASoundBuilderPacket(this);
			this.level = null;

			if (playTo != null) {
				for (Player pl : playTo) {
					if (exclude == null || !exclude.contains(pl))
						AoANetworking.sendToPlayer((ServerPlayer)pl, packet);
				}
			}
			else {
				for (ServerPlayer pl : serverLevel.getServer().getPlayerList().getPlayers()) {
					if (pl.level() == serverLevel && pl.distanceToSqr(location) <= radius * radius && (exclude == null || !exclude.contains(pl)))
						AoANetworking.sendToPlayer(pl, packet);
				}
			}
		}
		else {
			ClientOperations.playSoundFromBuilder(this);
		}
	}

	private void stop() {
		if (level == null || level.isClientSide()) {
			ClientOperations.stopSoundFromBuilder(this);
		}
		else {
			AoASoundBuilderPacket packet = new AoASoundBuilderPacket(this);

			if (playTo != null) {
				for (Player pl : playTo) {
					if (exclude == null || !exclude.contains(pl))
						AoANetworking.sendToPlayer((ServerPlayer)pl, packet);
				}
			}
			else {
				for (ServerPlayer pl : level.getServer().getPlayerList().getPlayers()) {
					if (pl.level() == level && pl.distanceToSqr(location) <= radius * radius && (exclude == null || !exclude.contains(pl)))
						AoANetworking.sendToPlayer(pl, packet);
				}
			}
		}
	}

	public static void toNetwork(RegistryFriendlyByteBuf buffer, SoundBuilder builder) {
		buffer.writeResourceLocation(RegistryUtil.getId(builder.sound));
		buffer.writeBoolean(builder.stopSound);

		ArrayList<Section> sections = new ArrayList<Section>();

		for (Section section : Section.values()) {
			if (section.shouldWrite.test(builder))
				sections.add(section);
		}

		buffer.writeVarInt(sections.size());

		for (Section section : sections) {
			buffer.writeEnum(section);
			section.writer.accept(builder, buffer);
		}
	}

	public static SoundBuilder fromNetwork(RegistryFriendlyByteBuf buffer) {
		SoundEvent sound = AoARegistries.SOUNDS.getEntry(buffer.readResourceLocation());
		SoundBuilder builder = new SoundBuilder(sound);
		builder.stopSound = buffer.readBoolean();

		int sections = buffer.readVarInt();

		for (int i = 0; i < sections; i++) {
			buffer.readEnum(Section.class).reader.accept(builder, buffer);
		}

		return builder;
	}

	enum Section {
		CATEGORY(builder -> builder.category != SoundSource.MASTER, (builder, buffer) -> {
			buffer.writeEnum(builder.category);
		}, (builder, buffer) -> {
			builder.category(buffer.readEnum(SoundSource.class));
		}),
		LOCATION(builder -> builder.location != null, (builder, buffer) -> {
			buffer.writeDouble(builder.location.x());
			buffer.writeDouble(builder.location.y());
			buffer.writeDouble(builder.location.z());
		}, (builder, buffer) -> {
			builder.atPos(ClientOperations.getLevel(), buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
		}),
		FOLLOWING_ENTITY(builder -> builder.followingEntity != null, (builder, buffer) -> {
			buffer.writeVarInt(builder.followingEntity.getId());
		}, (builder, buffer) -> {
			builder.followEntity(ClientOperations.getLevel().getEntity(buffer.readVarInt()));
		}),
		MOVING(builder -> builder.velocity != null, (builder, buffer) -> {
			buffer.writeVec3(builder.velocity);
		}, (builder, buffer) -> {
			builder.moving(buffer.readVec3());
		}),
		PITCH(builder -> builder.pitch != 1f, (builder, buffer) -> {
			buffer.writeFloat(builder.pitch);
		}, (builder, buffer) -> {
			builder.pitch(buffer.readFloat());
		}),
		RADIUS(builder -> builder.radius != 16f, (builder, buffer) -> {
			buffer.writeFloat(builder.radius);
		}, (builder, buffer) -> {
			builder.radius(buffer.readFloat());
		}),
		SCHEDULE_DELAY(builder -> builder.scheduleDelay != 0, (builder, buffer) -> {
			buffer.writeVarInt(builder.scheduleDelay);
		}, (builder, buffer) -> {
			builder.schedule(buffer.readVarInt());
		}),
		TIME_DILATION(builder -> builder.applyTimeDilation, (builder, buffer) -> {}, (builder, buffer) -> {
			builder.applyTimeDilation();
		}),
		IN_WORLD(builder -> !builder.inWorld, (builder, buffer) -> {}, (builder, buffer) -> {
			builder.notInWorld();
		}),
		LOOP(builder -> builder.loop, (builder, buffer) -> {}, (builder, buffer) -> {
			builder.loopSound();
		}),
		LOOP_DELAY(builder -> builder.loopDelay != 0, (builder, buffer) -> {
			buffer.writeVarInt(builder.loopDelay);
		}, (builder, buffer) -> {
			builder.loopSound(buffer.readVarInt());
		});

		final Predicate<SoundBuilder> shouldWrite;
		final BiConsumer<SoundBuilder, FriendlyByteBuf> writer;
		final BiConsumer<SoundBuilder, FriendlyByteBuf> reader;

		Section(Predicate<SoundBuilder> shouldWrite, BiConsumer<SoundBuilder, FriendlyByteBuf> writer, BiConsumer<SoundBuilder, FriendlyByteBuf> reader) {
			this.shouldWrite = shouldWrite;
			this.writer = writer;
			this.reader = reader;
		}
	}
}
