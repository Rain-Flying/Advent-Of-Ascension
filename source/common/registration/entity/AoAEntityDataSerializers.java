package net.tslat.aoa3.common.registration.entity;

import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.tslat.aoa3.common.registration.AoARegistries;
import net.tslat.aoa3.common.registration.entity.variant.ChargerVariant;
import net.tslat.aoa3.common.registration.entity.variant.DryadSpriteVariant;
import net.tslat.aoa3.common.registration.entity.variant.PixonVariant;
import net.tslat.aoa3.common.registration.entity.variant.VeloraptorVariant;

import java.util.function.Supplier;

public class AoAEntityDataSerializers {
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<PixonVariant>> PIXON_VARIANT = register("pixon_variant", () -> EntityDataSerializer.forValueType(ByteBufCodecs.registry(AoARegistries.PIXON_VARIANTS.key())));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<ChargerVariant>> CHARGER_VARIANT = register("charger_variant", () -> EntityDataSerializer.forValueType(ByteBufCodecs.registry(AoARegistries.CHARGER_VARIANTS.key())));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<VeloraptorVariant>> VELORAPTOR_VARIANT = register("veloraptor_variant", () -> EntityDataSerializer.forValueType(ByteBufCodecs.registry(AoARegistries.VELORAPTOR_VARIANTS.key())));
	public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<DryadSpriteVariant>> DRYAD_SPRITE_VARIANT = register("dryad_sprite_variant", () -> EntityDataSerializer.forValueType(ByteBufCodecs.registry(AoARegistries.DRYAD_SPRITE_VARIANTS.key())));

	public static void init() {}

	private static <T> DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<T>> register(String id, Supplier<EntityDataSerializer<T>> serializer) {
		return AoARegistries.ENTITY_DATA_SERIALIZERS.register(id, serializer);
	}
}
