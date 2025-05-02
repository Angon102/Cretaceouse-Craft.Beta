package net.Ang.Practiceccmod.datagen;


import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, Practiceccmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.GINKGOES_WOOD.get().asItem())
                .add(ModBlocks.GINKGOES_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGOES_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_GINKGOES_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.GINKGOES_PLANKS.get().asItem());
    }
}
