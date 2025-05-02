package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Practiceccmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.BANANA.get());
        basicItem(ModItems.GYPSUM_POWDER.get());
        basicItem(ModItems.PLASTER_AND_BANDAGE.get());
        basicItem(ModItems.TRICERATOPS_RIBCAGE.get());
        basicItem(ModItems.TRICERATOPS_HORN.get());
        basicItem(ModItems.TRICERATOPS_EGG.get());
        basicItem(ModItems.HATCHED_TRICERATOPS_EGG.get());
        basicItem(ModItems.COOKED_DINOSAUR_EGG.get());
        basicItem(ModItems.RAW_PLATINUM.get());
        basicItem(ModItems.PLATINUM_INGOT.get());
        basicItem(ModItems.PLATINUM_PICKAXE.get());
        basicItem(ModItems.PLATINUM_AXE.get());
        basicItem(ModItems.PLATINUM_SWORD.get());
        basicItem(ModItems.PLATINUM_SHOVEL.get());
        basicItem(ModItems.PLATINUM_HOE.get());
        basicItem(ModItems.FOSSIL_CUTTER.get());
        basicItem(ModItems.PLATINUM_HAMMER.get());
        basicItem(ModItems.CHARD_EGG.get());
        basicItem(ModItems.CHARD_TOMATO.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.COOKED_TOMATO.get());
        basicItem(ModItems.TOMATO_SEEDS.get());
        basicItem(ModItems.CABBAGE.get());
        basicItem(ModItems.CABBAGE_SEEDS.get());
        basicItem(ModItems.MOSQUITO_IN_AMBER.get());
        basicItem(ModItems.SYRINGE_TIP.get());
        basicItem(ModItems.SYRINGE.get());
        basicItem(ModItems.TRICERATOPS_SKULL.get());
        basicItem(ModItems.TRICERATOPS_SYRINGE.get());
        basicItem(ModItems.TAR.get());
        basicItem(ModItems.PINEAPPLE.get());
        basicItem(ModItems.PINEAPPLE_SEEDS.get());

        saplingItem(ModBlocks.GINKGOES_SAPLING);
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Practiceccmod.MOD_ID,"block/" + item.getId().getPath()));
    }
}
