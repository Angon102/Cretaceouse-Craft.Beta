package net.Ang.Practiceccmod.worldgen.tree;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower GINKGOES = new TreeGrower(Practiceccmod.MOD_ID + ":ginkgoes",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GINKGOES_KEY), Optional.empty());
}
