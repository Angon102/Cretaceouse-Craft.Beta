package net.Ang.Practiceccmod.block.custom;


import net.Ang.Practiceccmod.api.SubBlocksBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import static com.ibm.icu.number.NumberFormatter.UnitWidth.VARIANT;


public class FossilBlocks extends Block implements SubBlocksBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 15);

    private int start;


    public FossilBlocks(Properties p_49795_) {
        super(p_49795_);
    }

        @Override
    public BlockItem getBlockItem() {
        return null;
    }
}