package net.Ang.Practiceccmod.block;

import net.Ang.Practiceccmod.block.custom.FossilBlocks;
import net.Ang.Practiceccmod.dinosaur.Dinosaur;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.util.datafix.fixes.EntityBlockStateFix.getBlockId;
import static net.minecraft.world.item.Items.registerBlock;

public class ModBlockHandler {

    public static final List<FossilBlocks> FOSSILS = new ArrayList<>();

    public static FossilBlocks getFossilBlock(int id)
    {
        return FOSSILS.get(getBlockId(id));
    }

    private static int getBlockId(int id) {
        return 0;
    }

    public static int getDinosaurId(FossilBlocks fossil, int metadata)
    {
        return (FOSSILS.indexOf(fossil) * 16) + metadata;
    }
}
