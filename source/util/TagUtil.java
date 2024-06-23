package net.tslat.aoa3.util;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.stream.Stream;

public final class TagUtil {
	public static <T> boolean isTaggedAs(Level level, T object, TagKey<T>... tagKeys) {
		return level.registryAccess().registry(tagKeys[0].registry()).map(registry -> {
			Holder<T> holder = registry.wrapAsHolder(object);

			for (TagKey<T> tagKey : tagKeys) {
				if (holder.is(tagKey))
					return true;
			}

			return false;
		}).orElse(false);
	}

	public static <T> Stream<TagKey<T>> getAllTagsFor(ResourceKey<? extends Registry<T>> registryKey, T object, Level level) {
		Registry<T> registry = level.registryAccess().registry(registryKey).orElseGet(() -> BuiltInRegistries.REGISTRY.getOrThrow((ResourceKey)registryKey));

		return registry.getResourceKey(object).map(key -> registry.getHolderOrThrow(key).tags()).orElseGet(Stream::empty);
	}

	public static <T> Optional<HolderSet.Named<T>> getTagContents(TagKey<T> tag, Level level) {
		Optional<Registry<T>> vanillaRegistry = level.registryAccess().registry(tag.registry());

		return vanillaRegistry
				.map(registry -> registry.getTag(tag))
				.orElseGet(() -> BuiltInRegistries.REGISTRY.get((ResourceKey)tag.registry()).getTag(tag));
	}
}
