package net.Ang.Practiceccmod.datagen;

import net.Ang.Practiceccmod.Practiceccmod;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.item.crafting.RecipeSerializer.CAMPFIRE_COOKING_RECIPE;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> PLATINUM_SMELTABLES = List.of(ModItems.RAW_PLATINUM.get(),
                ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        List<ItemLike> EGG_MEAL = List.of(ModItems.TRICERATOPS_EGG.get());
        List<ItemLike> CHARD_EGG = List.of(ModItems.CHARD_EGG.get());
        List<ItemLike> TOMATO = List.of(ModItems.TOMATO.get());
        List<ItemLike> CTOMATO = List.of(ModItems.COOKED_TOMATO.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AMBER_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AMBER.get())
                .unlockedBy(getHasName(ModItems.AMBER.get()), has(ModItems.AMBER.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AMBER.get(), 9)
                .requires(ModBlocks.AMBER_BLOCK.get())
        .unlockedBy(getHasName(ModBlocks.AMBER_BLOCK.get()), has(ModBlocks.AMBER_BLOCK.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_PLATINUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_PLATINUM.get())
                .unlockedBy(getHasName(ModItems.RAW_PLATINUM.get()), has(ModItems.RAW_PLATINUM.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_PLATINUM.get(), 9)
                .requires(ModBlocks.RAW_PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_PLATINUM_BLOCK.get()), has(ModBlocks.RAW_PLATINUM_BLOCK.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AMBER_STONE_BRICKS.get(), 4)
                .pattern("ABA")
                .pattern("BAB")
                .pattern("ABA")
                .define('A', ModItems.AMBER.get())
                .define('B', Items.STONE_BRICKS)
                .unlockedBy(getHasName(Items.STONE_BRICKS), has(ModItems.AMBER.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLASTER_AND_BANDAGE.get(), 9)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', ModItems.GYPSUM_POWDER.get())
                .define('B', Items.PAPER)
                .define('C', Items.WHITE_WOOL)
                .unlockedBy(getHasName(ModItems.GYPSUM_POWDER.get()), has(ModItems.GYPSUM_POWDER.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_CUTTER.get(), 1)
                .pattern(" A ")
                .pattern(" A ")
                .pattern("CBC")
                .define('A', ModItems.PLATINUM_INGOT.get())
                .define('B', Items.STICK)
                .define('C', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(Items.LAPIS_LAZULI)).save(pRecipeOutput);




        oreSmelting(pRecipeOutput,PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.5f, 200, "platinum");
        oreBlasting(pRecipeOutput,PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.5f, 100, "platinum");
        oreSmelting(pRecipeOutput,EGG_MEAL, RecipeCategory.MISC, ModItems.COOKED_DINOSAUR_EGG.get(), 1.5f, 200, "egg");
        oreSmoking(pRecipeOutput,EGG_MEAL, RecipeCategory.MISC, ModItems.COOKED_DINOSAUR_EGG.get(), 1.5f, 100, "egg");
        oreSmelting(pRecipeOutput,CHARD_EGG, RecipeCategory.MISC, ModItems.CHARD_EGG.get(), 1.5f, 200, "egg");
        oreSmoking(pRecipeOutput,CHARD_EGG, RecipeCategory.MISC, ModItems.CHARD_EGG.get(), 1.5f, 100, "egg");
        oreSmelting(pRecipeOutput,TOMATO, RecipeCategory.MISC, ModItems. COOKED_TOMATO.get(), 1.5f, 200, "egg");
        oreSmoking(pRecipeOutput,TOMATO, RecipeCategory.MISC, ModItems.COOKED_TOMATO.get(), 1.5f, 100, "egg");
        oreSmelting(pRecipeOutput,CTOMATO, RecipeCategory.MISC, ModItems. CHARD_TOMATO.get(), 1.5f, 200, "egg");
        oreSmoking(pRecipeOutput,CTOMATO, RecipeCategory.MISC, ModItems.CHARD_TOMATO.get(), 1.5f, 100, "egg");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }
    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Practiceccmod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
