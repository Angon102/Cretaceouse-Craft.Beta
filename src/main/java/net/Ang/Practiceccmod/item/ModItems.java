package net.Ang.Practiceccmod.item;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.item.custom.FossilCutterItem;
import net.Ang.Practiceccmod.item.custom.FuelItem;
import net.Ang.Practiceccmod.item.custom.HammerItem;
import net.Ang.Practiceccmod.item.custom.PlasterAndBandageItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Practiceccmod.MOD_ID);

    public static final RegistryObject<Item> TRICERATOPS_RIBCAGE = ITEMS.register("triceratops_ribcage",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE)));

    public static final RegistryObject<Item> FOSSIL_CUTTER = ITEMS.register("fossil_cutter",
            () -> new FossilCutterItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SYRINGE = ITEMS.register("syringe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRICERATOPS_SYRINGE = ITEMS.register("triceratops_syringe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRICERATOPS_SKULL = ITEMS.register("triceratops_skull",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TAR = ITEMS.register("tar",
            () -> new FuelItem(new Item.Properties(), 2400));

    public static final RegistryObject<Item> SYRINGE_TIP = ITEMS.register("syringe_tip",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOSQUITO_IN_AMBER = ITEMS.register("mosquito_in_amber",
            () -> new Item(new Item.Properties()));

public static final RegistryObject<Item> CABBAGE_SEEDS = ITEMS.register("cabbage_seeds",
        () -> new ItemNameBlockItem(ModBlocks.CABBAGE_CROP.get(), new Item.Properties()));

    public static  final RegistryObject<Item> CABBAGE = ITEMS.register("cabbage",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CABBAGE)));

    public static final RegistryObject<Item> GYPSUM_POWDER = ITEMS.register("gypsum_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRICERATOPS_HORN = ITEMS.register("triceratops_horn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLASTER_AND_BANDAGE = ITEMS.register("plaster_and_bandage",
            () -> new PlasterAndBandageItem(new Item.Properties()));

    public static final RegistryObject<Item> TRICERATOPS_EGG = ITEMS.register("triceratops_egg",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRICERATOPS_TISSUE = ITEMS.register("triceratops_tissue",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seed",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CHARD_EGG = ITEMS.register("chard_egg",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> CHARD_TOMATO = ITEMS.register("chard_tomato",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));

    public static final RegistryObject<Item> COOKED_TOMATO = ITEMS.register("cooked_tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_TOMATO)));

    public static final RegistryObject<Item> HATCHED_TRICERATOPS_EGG = ITEMS.register("hatched_triceratops_egg",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_HAMMER = ITEMS.register("platinum_hammer",
            () -> new HammerItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PLATINUM, 5000000, -0.0f))));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PLATINUM, 2, -2.8f))));

    public static final RegistryObject<Item> COOKED_DINOSAUR_EGG = ITEMS.register("cooked_dinosaur_egg",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_DINOSAUR_EGG)));

    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.PLATINUM, 5, -3f))));

    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.PLATINUM, 2, -0.0f))));

    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PLATINUM, 2, -3.1f))));

    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PLATINUM, 4, -2.4f))));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
