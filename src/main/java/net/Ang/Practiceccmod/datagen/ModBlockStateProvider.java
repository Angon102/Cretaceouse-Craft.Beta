package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.block.crops.CabbageCropBlock;
import net.Ang.Practiceccmod.block.crops.PineappleCropBlock;
import net.Ang.Practiceccmod.block.crops.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Practiceccmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AMBER_BLOCK);
        blockWithItem(ModBlocks.TAR_BLOCK);
        blockWithItem(ModBlocks.FOSSIL_1);
        blockWithItem(ModBlocks.FOSSIL_BLOCK_2);
        blockWithItem(ModBlocks.DEEPSLATE_FOSSIL_1);
        blockWithItem(ModBlocks.AMBER_STONE_BRICKS);
        blockWithItem(ModBlocks.AMBER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE);
        blockWithItem(ModBlocks.ENCASED_FOSSIL_1);
        blockWithItem(ModBlocks.ENCASED_FOSSIL_2);
        blockWithItem(ModBlocks.GYPSUM);
        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_PLATINUM_ORE);


        logBlock(ModBlocks.GINKGOES_LOG.get());
        axisBlock(ModBlocks.GINKGOES_WOOD.get(), blockTexture(ModBlocks.GINKGOES_LOG.get()), blockTexture(ModBlocks.GINKGOES_LOG.get()));
        logBlock(ModBlocks.STRIPPED_GINKGOES_LOG.get());
        axisBlock(ModBlocks.STRIPPED_GINKGOES_WOOD.get(), blockTexture(ModBlocks.STRIPPED_GINKGOES_LOG.get()), blockTexture(ModBlocks.STRIPPED_GINKGOES_LOG.get()));

        leavesBlock(ModBlocks.GINKGOES_LEAVES);
        saplingBlock(ModBlocks.GINKGOES_SAPLING);

        blockItem(ModBlocks.GINKGOES_LOG);
        blockItem(ModBlocks.GINKGOES_WOOD);
        blockItem(ModBlocks.STRIPPED_GINKGOES_LOG);
        blockItem(ModBlocks.STRIPPED_GINKGOES_WOOD);

        blockWithItem(ModBlocks.GINKGOES_PLANKS);

        makePineappleCrop((CropBlock) ModBlocks.PINEAPPLE_CROP.get(),"pineapple_stage","pineapple_stage");
        makeTomatoCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeCabbageCrop((CropBlock) ModBlocks.CABBAGE_CROP.get(), "cabbage_stage", "cabbage_stage");
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }




    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> TomatoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makePineappleCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> PineappleStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makeCabbageCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> CabbageStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);


    }



    private ConfiguredModel[] PineappleStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PineappleCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Practiceccmod.MOD_ID, "block/" + textureName + state.getValue(((PineappleCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] TomatoStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Practiceccmod.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] CabbageStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CabbageCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Practiceccmod.MOD_ID, "block/" + textureName + state.getValue(((CabbageCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("practiceccmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("practiceccmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
