package net.Ang.Practiceccmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COOKED_DINOSAUR_EGG = new FoodProperties.Builder().nutrition(15).saturationModifier(0.8f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400), 2f).build();

    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(2).build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(2).build();

    public static final FoodProperties COOKED_TOMATO = new FoodProperties.Builder().nutrition(3).build();

    public static final FoodProperties CABBAGE = new FoodProperties.Builder().nutrition(2).build();

    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(2).build();
}