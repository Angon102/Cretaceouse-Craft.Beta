package net.Ang.Practiceccmod.genetics;

import net.Ang.Practiceccmod.dinosaur.Dinosaur;

public class DinoDNA {
    private int quality;
    private String genetics;
    private Dinosaur dinosaur;

    public DinoDNA(Dinosaur dinosaur, int quality, String genetics) {
        this.quality = quality;
        this.genetics = genetics;
        this.dinosaur = dinosaur;
    }

    public Dinosaur getDinosaur() {
        return this.dinosaur;
    }
}
