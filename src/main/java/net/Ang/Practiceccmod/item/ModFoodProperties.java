package net.Ang.Practiceccmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COOKED_DINOSAUR_EGG = new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400), 2f).build();
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2f)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 400), 2f).build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 200), 2f).build();
    public static final FoodProperties COOKED_TOMATO = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 200), 2f).build();
    public static final FoodProperties CABBAGE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .effect(new MobEffectInstance(MobEffects.HEAL, 200), 2f).build();

}