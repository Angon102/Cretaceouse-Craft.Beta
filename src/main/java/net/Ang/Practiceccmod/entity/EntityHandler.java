package net.Ang.Practiceccmod.entity;

import net.Ang.Practiceccmod.dinosaur.Dinosaur;
import net.Ang.Practiceccmod.dinosaur.TriceratopsDinosaur;
import net.minecraft.world.entity.animal.Animal;

import java.util.HashMap;
import java.util.Map;

public class EntityHandler {

    public static final Dinosaur TRICERATOPS = new TriceratopsDinosaur();

    private static final Map<Integer, Dinosaur> DINOSAURS = new HashMap<>();
    private static final Map<Integer, Animal> ANIMALS = new HashMap<>();
    private static final Map<Dinosaur, Integer> DINOSAUR_IDS = new HashMap<>();
    private static final Map<Animal, Integer> ANIMAL_IDS = new HashMap<>();

    private static int entityId;

    private static int highestAnimalID;
    private static int highestDinosaurID;

    public static void init() {
        registerDinosaur(19, TRICERATOPS);
    }

    public static void registerDinosaur(int id, Dinosaur dinosaur) {
        if (id > highestDinosaurID) {
            highestDinosaurID = id;
        }

        DINOSAURS.put(id, dinosaur);
        DINOSAUR_IDS.put(dinosaur, id);
    }
}
