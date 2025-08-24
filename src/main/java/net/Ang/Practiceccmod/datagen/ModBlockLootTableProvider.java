package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.block.crops.CabbageCropBlock;
import net.Ang.Practiceccmod.block.crops.TomatoCropBlock;
import net.Ang.Practiceccmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate(){
        dropSelf(ModBlocks.AMBER_STONE_BRICKS.get());
        dropSelf(ModBlocks.AMBER_BLOCK.get());
        dropSelf(ModBlocks.ENCASED_FOSSIL_1.get());
        dropSelf(ModBlocks.ENCASED_FOSSIL_2.get());
        dropSelf(ModBlocks.CLEANING_STATION.get());
        dropSelf(ModBlocks.RAW_PLATINUM_BLOCK.get());
        dropSelf(ModBlocks.FOSSIL_GRINDER.get());
        dropSelf(ModBlocks.PLATINUM_BLOCK.get());

        dropSelf(ModBlocks.GINKGOES_SAPLING.get());
        dropSelf(ModBlocks.GINKGOES_LOG.get());
        dropSelf(ModBlocks.GINKGOES_WOOD.get());
        dropSelf(ModBlocks.GINKGOES_PLANKS.get());
        dropSelf(ModBlocks.STRIPPED_GINKGOES_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_GINKGOES_LOG.get());

        dropSelf(ModBlocks.CLEANING_STATION.get());

        this.add(ModBlocks.GINKGOES_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.GINKGOES_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.AMBER_ORE.get(),
                Block -> createMultipleOreDrops(ModBlocks.AMBER_ORE.get(), ModItems.AMBER.get(), 1, 6));
        this.add(ModBlocks.TAR_BLOCK.get(),
                Block -> createMultipleOreDrops(ModBlocks.TAR_BLOCK.get(), ModItems.TAR.get(), 4, 8));
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                Block -> createOreDrop(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
        this.add(ModBlocks.PLATINUM_ORE.get(),
                Block -> createOreDrop(ModBlocks.PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
        this.add(ModBlocks.DEEPSLATE_AMBER_ORE.get(),
                Block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_AMBER_ORE.get(), ModItems.AMBER.get(), 1, 6));
        this.add(ModBlocks.GYPSUM.get(),
                Block -> createMultipleOreDrops(ModBlocks.GYPSUM.get(), ModItems.GYPSUM_POWDER.get(), 3, 10 ));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CABBAGE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CabbageCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PINEAPPLE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        this.add(ModBlocks.CABBAGE_CROP.get(),
                createCropDrops(ModBlocks.CABBAGE_CROP.get(), ModItems.CABBAGE.get(), ModItems.CABBAGE_SEEDS.get(), lootitemcondition$builder2));

        this.add(ModBlocks.TOMATO_CROP.get(),
                createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootitemcondition$builder1));

        this.add(ModBlocks.PINEAPPLE_CROP.get(),
                createCropDrops(ModBlocks.PINEAPPLE_CROP.get(), ModItems.PINEAPPLE.get(), ModItems.PINEAPPLE_SEEDS.get(), lootitemcondition$builder3));
    }


    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )

        );
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
