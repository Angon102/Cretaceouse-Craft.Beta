package net.Ang.Practiceccmod.block.entity.custom;

import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.block.entity.ModBlockEntities;
import net.Ang.Practiceccmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.GroupLayout;

import static net.Ang.Practiceccmod.Config.items;

public class CleaningStationBlockEntity extends BlockEntity implements MenuProvider {
    public  final ItemStackHandler itemHandler = new ItemStackHandler(13){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState() , 3);
            }
        }
    };

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int OUTPUT_SLOT_1 = 3;
    private static final int OUTPUT_SLOT_2 = 4;
    private static final int OUTPUT_SLOT_3 = 5;
    private static final int OUTPUT_SLOT_4 = 6;
    private static final int OUTPUT_SLOT_5 = 7;
    private static final int OUTPUT_SLOT_6 = 8;
    private static final int OUTPUT_SLOT_7 = 9;
    private static final int OUTPUT_SLOT_8 = 10;
    private static final int OUTPUT_SLOT_9 = 11;
    private static final int OUTPUT_SLOT_10 = 12;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 60;


    public CleaningStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CLEANING_STATION_BE.get(), pPos, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> CleaningStationBlockEntity.this.progress;
                    case 1 -> CleaningStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0: CleaningStationBlockEntity.this.progress = value;
                    case 1: CleaningStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler );
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("cleaning_station.progress", progress);
        pTag.putInt("cleaning_station.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.practiceccmod.cleaning_staion");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()){
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if (hasCraftingFinished()){
                craftItem();
                resetProgress();
            }
        }else {
            resetProgresss();
        }
    }

    private boolean hasRecipe() {
        Item input = Items.GRASS_BLOCK;
        ItemStack output = new ItemStack(ModItems.TRICERATOPS_HORN.get());

        return itemHandler.getStackInSlot(INPUT_SLOT_2).is(input);
    }
}

