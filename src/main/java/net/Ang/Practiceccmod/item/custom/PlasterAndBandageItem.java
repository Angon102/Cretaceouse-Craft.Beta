package net.Ang.Practiceccmod.item.custom;

import net.Ang.Practiceccmod.block.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class PlasterAndBandageItem extends Item {
        private static final Map<Block, Block> PlasterAndBandage_MAP =
                Map.of(
                        ModBlocks.FOSSIL_1.get(),  ModBlocks.ENCASED_FOSSIL_1.get(),
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
