package net.Ang.Practiceccmod.block.entity;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.block.entity.custom.CleaningStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Practiceccmod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CleaningStationBlockEntity>> CLEANING_STATION_BE =
            BLOCK_ENTITIES.register("cleaning_station_be", () -> BlockEntityType.Builder.of(
            CleaningStationBlockEntity::new, ModBlocks.CLEANING_STATION.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
