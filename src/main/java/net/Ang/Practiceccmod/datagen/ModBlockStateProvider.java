package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.block.crops.CabbageCropBlock;
import net.Ang.Practiceccmod.block.crops.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Practiceccmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AMBER_BLOCK);
        blockWithItem(ModBlocks.CLEANING_STATION);
        blockWithItem(ModBlocks.FOSSIL_BLOCK_1);
        blockWithItem(ModBlocks.FOSSIL_BLOCK_2);
        blockWithItem(ModBlocks.AMBER_STONE_BRICKS);
        blockWithItem(ModBlocks.AMBER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE);
        blockWithItem(ModBlocks.ENCASED_FOSSIL_1);
        blockWithItem(ModBlocks.ENCASED_FOSSIL_2);
        blockWithItem(ModBlocks.GYPSUM);
        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_PLATINUM_ORE);

        makeTomatoCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeCabbageCrop((CropBlock) ModBlocks.CABBAGE_CROP.get(), "cabbage_stage", "cabbage_stage");
    }
    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> TomatoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makeCabbageCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> CabbageStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
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
}
