package net.Ang.Practiceccmod.item;


import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.Practiceccmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;



public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Practiceccmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FOSSIL_ITEM_TAB = CREATIVE_MODE_TABS.register("fossil_item_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMBER.get()))
            .title(Component.translatable( "creativetab.practiceccmod.fossil_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AMBER.get());
                        output.accept(ModItems.GYPSUM_POWDER.get());
                        output.accept(ModItems.TRICERATOPS_RIBCAGE.get());
                        output.accept(ModItems.TRICERATOPS_HORN.get());
                        output.accept(ModItems.PLASTER_AND_BANDAGE.get());
                        output.accept(ModItems.TRICERATOPS_EGG.get());
                        output.accept(ModItems.HATCHED_TRICERATOPS_EGG.get());
                        output.accept(ModItems.RAW_PLATINUM.get());
                        output.accept(ModItems.PLATINUM_INGOT.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOMATO.get()))
                    .title(Component.translatable( "creativetab.practiceccmod.food_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.CHARD_TOMATO.get());
                        output.accept(ModItems.CHARD_EGG.get());
                        output.accept(ModItems.TOMATO.get());
                        output.accept(ModItems.COOKED_DINOSAUR_EGG.get());
                        output.accept(ModItems.COOKED_TOMATO.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModItems.CABBAGE_SEEDS.get());
                        output.accept(ModItems.CABBAGE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> TOOLS_TAB = CREATIVE_MODE_TABS.register("tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINUM_INGOT.get()))
                    .title(Component.translatable( "creativetab.practiceccmod.Tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PLATINUM_PICKAXE.get());
                        output.accept(ModItems.PLATINUM_INGOT.get());
                        output.accept(ModItems.PLATINUM_AXE.get());
                        output.accept(ModItems.PLATINUM_SWORD.get());
                        output.accept(ModItems.PLATINUM_HOE.get());
                        output.accept(ModItems.PLATINUM_SHOVEL.get());
                        output.accept(ModItems.FOSSIL_CUTTER.get());
                        output.accept(ModItems.PLATINUM_HAMMER.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> FOSSIL_Block_TAB = CREATIVE_MODE_TABS.register("fossil_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FOSSIL_BLOCK_1.get()))
                    .withTabsBefore(FOSSIL_ITEM_TAB.getId())
                    .title(Component.translatable( "creativetab.practiceccmod.fossil_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.FOSSIL_BLOCK_1.get());
                        output.accept(ModBlocks.FOSSIL_BLOCK_2.get());
                        output.accept(ModBlocks.GYPSUM.get());
                        output.accept(ModBlocks.AMBER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AMBER_ORE.get());
                        output.accept(ModBlocks.ENCASED_FOSSIL_1.get());
                        output.accept(ModBlocks.ENCASED_FOSSIL_2.get());
                        output.accept(ModBlocks.CLEANING_STATION.get());
                        output.accept(ModBlocks.AMBER_BLOCK.get());
                        output.accept(ModBlocks.AMBER_STONE_BRICKS.get());
                        output.accept(ModBlocks.PLATINUM_ORE.get());
                        output.accept(ModBlocks.RAW_PLATINUM_BLOCK.get());
                        output.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
