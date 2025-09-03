package net.Ang.Practiceccmod.item;

import net.Ang.Practiceccmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier PLATINUM = new ForgeTier(2401, 90, 3f, 20,
            ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_PLATINUM_TOOL);
}
