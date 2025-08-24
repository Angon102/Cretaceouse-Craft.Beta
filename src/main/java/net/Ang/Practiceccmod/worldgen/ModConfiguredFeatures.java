package net.Ang.Practiceccmod.worldgen;


import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AMBER_ORE_KEY = registerKey("amber_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PLATINUM_ORE_KEY = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GYPSUM_KEY = registerKey("gypsum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FOSSIL_1_KEY = registerKey("fossil_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FOSSIL_2_KEY = registerKey("fossil_2");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGOES_KEY = registerKey("ginkgoes");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldAmberOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.AMBER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_AMBER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldPlatinumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldGypsumOre = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.GYPSUM.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldFossil_1Ore = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.FOSSIL_1.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldFossil_2Ore = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.FOSSIL_BLOCK_2.get().defaultBlockState()));

        register(context, OVERWORLD_AMBER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAmberOres, 9));
        register(context, OVERWORLD_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPlatinumOres, 8));
        register(context, OVERWORLD_GYPSUM_KEY, Feature.ORE, new OreConfiguration(overworldGypsumOre, 20));
        register(context, OVERWORLD_FOSSIL_1_KEY, Feature.ORE, new OreConfiguration(overworldFossil_1Ore, 15));
        register(context, OVERWORLD_FOSSIL_2_KEY, Feature.ORE, new OreConfiguration(overworldFossil_2Ore, 15));

        register(context, GINKGOES_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.GINKGOES_LOG.get()),
                new ForkingTrunkPlacer(4,4,3),

                BlockStateProvider.simple(ModBlocks.GINKGOES_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3),3),

                new TwoLayersFeatureSize(1,0,2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Practiceccmod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}