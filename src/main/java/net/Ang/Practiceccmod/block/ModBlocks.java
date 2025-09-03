package net.Ang.Practiceccmod.block;

import net.Ang.Practiceccmod.block.crops.CabbageCropBlock;
import net.Ang.Practiceccmod.block.crops.PineappleCropBlock;
import net.Ang.Practiceccmod.block.crops.TomatoCropBlock;
import net.Ang.Practiceccmod.block.custom.CleaningStationBlock;
import net.Ang.Practiceccmod.block.custom.ModFlammableRotatedPillarBlock;
import net.Ang.Practiceccmod.item.ModItems;
import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Practiceccmod.MOD_ID);

    public static final RegistryObject<Block> FOSSIL_1 = registerBlock( "fossil_1",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(3.0f,3.0f)
                    .sound(SoundType.STONE).noLootTable()));

    public static final RegistryObject<Block> DEEPSLATE_FOSSIL_1 = registerBlock( "deepslate_fossil_1",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(3.0f,3.0f)
                    .sound(SoundType.STONE).noLootTable()));

    public static final RegistryObject<Block> FOSSIL_BLOCK_2 = registerBlock( "fossil_block_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f,3.0f)
                    .sound(SoundType.STONE).noLootTable()));


    public static final RegistryObject<Block> TAR_BLOCK = registerBlock( "tar_block",
            () -> new DropExperienceBlock(ConstantInt.of(10),
                    (BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(4.5f,3.0f)
                            .requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> GYPSUM = registerBlock( "gypsum_block",
            () -> new DropExperienceBlock(ConstantInt.of(10),
                    (BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(4.5f,3.0f)
                            .requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> AMBER_ORE = registerBlock( "amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,10),
                    (BlockBehaviour.Properties.of()
                    .strength(3.0f,3.0f)
                    .requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> DEEPSLATE_AMBER_ORE = registerBlock( "deepslate_amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,10),
                    (BlockBehaviour.Properties.of()
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

    public static final RegistryObject<Block> FOSSIL_GRINDER = registerBlock( "fossil_grinder",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .noOcclusion()
                    .noCollission()));

    public static final  RegistryObject<Block> CLEANING_STATION = registerBlock("cleaning_station",
            () -> new CleaningStationBlock(BlockBehaviour.Properties.of()));

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
                    .strength(5.0f,4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock( "raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f,4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock( "platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f,4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock( "deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f,4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> TOMATO_CROP = registerBlock( "tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PINEAPPLE_CROP = registerBlock( "pineapple_crop",
            () -> new PineappleCropBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CABBAGE_CROP = registerBlock( "cabbage_crop",
            () -> new CabbageCropBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> GINKGOES_SAPLING = registerBlock("ginkgoes_sapling",
            () -> new SaplingBlock(ModTreeGrowers.GINKGOES, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> GINKGOES_LEAVES = registerBlock("ginkgoes_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });


    public static final RegistryObject<RotatedPillarBlock> GINKGOES_LOG = registerBlock("ginkgoes_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> GINKGOES_WOOD = registerBlock("ginkgoes_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_GINKGOES_LOG = registerBlock("stripped_ginkgoes_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock>  STRIPPED_GINKGOES_WOOD = registerBlock("stripped_ginkgoes_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> GINKGOES_PLANKS = registerBlock("ginkgoes_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

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
