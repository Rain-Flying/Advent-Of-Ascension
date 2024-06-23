package net.tslat.aoa3.content.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.registration.block.AoABlockEntities;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LunarCreationTableBlockEntity extends BlockEntity implements Nameable, MenuProvider {
	private static final Component DEFAULT_NAME = Component.translatable("container." + AdventOfAscension.MOD_ID + ".lunar_creation_table");

	private final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

	@Nullable
	private Component customName;

	public LunarCreationTableBlockEntity(BlockPos pos, BlockState state) {
		super(AoABlockEntities.LUNAR_CREATION_TABLE.get(), pos, state);
	}

	public NonNullList<ItemStack> getContents() {
		return this.items;
	}

	public void dropContents(Level world, BlockPos pos) {
		for (ItemStack stack : getContents()) {
			world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d, stack));
		}

		this.items.clear();
		setChanged();
	}

	public void setContents(List<ItemStack> contents) {
		this.items.clear();

		for (int i = 0; i < 9 && contents.size() > i; i++) {
			this.items.set(i, contents.get(i));
		}

		setChanged();

		if (level != null)
			level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
		CompoundTag tag = super.getUpdateTag(registryLookup);

		ContainerHelper.saveAllItems(tag, this.items, registryLookup);

		return tag;
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider registryLookup) {
		super.saveAdditional(compound, registryLookup);

		ContainerHelper.saveAllItems(compound, this.items, registryLookup);

		if (this.customName != null)
			compound.putString("CustomName", Component.Serializer.toJson(this.customName, registryLookup));
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider registryLookup) {
		super.loadAdditional(compound, registryLookup);

		this.items.clear();
		ContainerHelper.loadAllItems(compound, this.items, registryLookup);

		this.customName = compound.contains("CustomName", Tag.TAG_STRING) ? parseCustomNameSafe(compound.getString("CustomName"), registryLookup) : null;
	}

	@Override
	public Component getName() {
		return this.customName != null ? this.customName : DEFAULT_NAME;
	}

	@Override
	public Component getDisplayName() {
		return getName();
	}

	public void setCustomName(@Nullable Component name) {
		this.customName = name;
	}

	@Nullable
	public Component getCustomName() {
		return this.customName;
	}

	@Nullable
	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Nullable
	@Override
	public CraftingMenu createMenu(int containerId, Inventory playerInventory, Player openingPlayer) {
		CraftingMenu container = new CraftingMenu(containerId, playerInventory, ContainerLevelAccess.create(getLevel(), getBlockPos())) {
			@Override
			protected void clearContainer(Player player, Container container) {
				setContents(this.craftSlots.getItems());

				this.craftSlots.clearContent();

				super.clearContainer(player, container);
			}

			@Override
			public void slotsChanged(Container inventory) {
				if (openingPlayer.containerMenu == this)
					setContents(this.craftSlots.getItems());

				super.slotsChanged(inventory);
			}

			@Override
			public boolean stillValid(Player player) {
				return stillValid(this.access, player, AoABlocks.LUNAR_CREATION_TABLE.get());
			}
		};

		NonNullList<ItemStack> contents = getContents();

		for (int i = 0; i < contents.size(); i++) {
			container.craftSlots.setItem(i, contents.get(i));
		}

		return container;
	}

	@Override
	protected void applyImplicitComponents(DataComponentInput components) {
		super.applyImplicitComponents(components);

		setCustomName(components.get(DataComponents.CUSTOM_NAME));
		components.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(getContents());
	}

	@Override
	protected void collectImplicitComponents(DataComponentMap.Builder builder) {
		super.collectImplicitComponents(builder);

		builder.set(DataComponents.CUSTOM_NAME, this.customName);
		builder.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(getContents()));
	}

	@Override
	public void removeComponentsFromTag(CompoundTag tag) {
		tag.remove("CustomName");
		tag.remove("Items");
	}
}
