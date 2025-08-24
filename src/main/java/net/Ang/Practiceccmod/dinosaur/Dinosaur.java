package net.Ang.Practiceccmod.dinosaur;

public abstract class Dinosaur implements Comparable<Dinosaur> {

    public static enum DinosaurType {
        AGGRESSIVE,
        NEUTRAL,
        PASSIVE,
        SCARED
    }

    public static enum BirthType {
        LIVE_BIRTH,
        EGG_LAYING
    }
}
