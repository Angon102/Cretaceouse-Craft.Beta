package net.Ang.Practiceccmod.item.custom;

import net.Ang.Practiceccmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

public class PlasterAndBandageItem extends Item {
        private static final Map<Block, Block> PlasterAndBandage_MAP =
                Map.of(
                        ModBlocks.FOSSIL_BLOCK_1.get(),  ModBlocks.ENCASED_FOSSIL_1.get(),
                        ModBlocks.FOSSIL_BLOCK_2.get(),  ModBlocks.ENCASED_FOSSIL_2.get()
                );
    public PlasterAndBandageItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(PlasterAndBandage_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), PlasterAndBandage_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().shrink(1);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
