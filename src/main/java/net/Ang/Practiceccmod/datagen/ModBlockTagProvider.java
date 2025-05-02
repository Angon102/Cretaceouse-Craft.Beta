package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Practiceccmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.AMBER_BLOCK.get())
            .add(ModBlocks.CLEANING_STATION.get())
            .add(ModBlocks.DEEPSLATE_AMBER_ORE.get())
            .add(ModBlocks.GYPSUM.get())
            .add(ModBlocks.ENCASED_FOSSIL_1.get())
            .add(ModBlocks.ENCASED_FOSSIL_2.get())
            .add(ModBlocks.PLATINUM_ORE.get())
            .add(ModBlocks.RAW_PLATINUM_BLOCK.get())
            .add(ModBlocks.AMBER_ORE.get())
            .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get())
            .add(ModBlocks.TAR_BLOCK.get());


    tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.AMBER_BLOCK.get())
            .add(ModBlocks.DEEPSLATE_AMBER_ORE.get())
            .add(ModBlocks.ENCASED_FOSSIL_1.get())
            .add(ModBlocks.ENCASED_FOSSIL_2.get())
            .add(ModBlocks.AMBER_ORE.get());
    tag(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.CLEANING_STATION.get())
            .add(ModBlocks.GYPSUM.get())
            .add(ModBlocks.TAR_BLOCK.get());
    tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.PLATINUM_ORE.get())
            .add(ModBlocks.RAW_PLATINUM_BLOCK.get())
            .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
    tag(ModTags.Blocks.NEEDS_PLATINUM_TOOL)
            .add(ModBlocks.PLATINUM_ORE.get())
            .add(ModBlocks.RAW_PLATINUM_BLOCK.get())
            .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
    this.tag(BlockTags.LOGS_THAT_BURN)
            .add(ModBlocks.GINKGOES_WOOD.get())
            .add(ModBlocks.GINKGOES_LOG.get())
            .add(ModBlocks.STRIPPED_GINKGOES_LOG.get())
            .add(ModBlocks.STRIPPED_GINKGOES_WOOD.get());
    }
}
