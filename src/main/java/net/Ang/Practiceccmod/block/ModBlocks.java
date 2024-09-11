package net.Ang.Practiceccmod.block;

import net.Ang.Practiceccmod.block.crops.CabbageCropBlock;
import net.Ang.Practiceccmod.block.crops.TomatoCropBlock;
import net.Ang.Practiceccmod.item.ModItems;
import net.Ang.Practiceccmod.Practiceccmod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.WHEAT;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Practiceccmod.MOD_ID);

    public static final RegistryObject<Block> FOSSIL_BLOCK_1 = registerBlock( "fossil_block_1",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(3f)
                    .sound(SoundType.STONE).noLootTable()));

    public static final RegistryObject<Block> FOSSIL_BLOCK_2 = registerBlock( "fossil_block_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .sound(SoundType.STONE).noLootTable()));

    public static final RegistryObject<Block> GYPSUM = registerBlock( "gypsum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BASALT)));

    public static final RegistryObject<Block> AMBER_ORE = registerBlock( "amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,10), (BlockBehaviour.Properties.of()
                    .strength(3.0f,3.0f)
                    .requiresCorrectToolForDrops())));
    public static final RegistryObject<Block> DEEPSLATE_AMBER_ORE = registerBlock( "deepslate_amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,10), (BlockBehaviour.Properties.of()
                    .strength(4.5f,3.0f)
                    .requiresCorrectToolForDrops())));
    public static final RegistryObject<Block> ENCASED_FOSSIL_1 = registerBlock( "encased_fossil_1",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.2f)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ENCASED_FOSSIL_2 = registerBlock( "encased_fossil_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.2f)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Block> CLEANING_STATION = registerBlock( "cleaning_station",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> AMBER_BLOCK = registerBlock( "amber_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> AMBER_STONE_BRICKS = registerBlock( "amber_stone_brick_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock( "platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock( "raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock( "deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f,4)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> TOMATO_CROP = registerBlock( "tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.of().sound(SoundType.CROP)));

    public static final RegistryObject<Block> CABBAGE_CROP = registerBlock( "cabbage_crop",
            () -> new CabbageCropBlock(BlockBehaviour.Properties.of().sound(SoundType.CROP)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
