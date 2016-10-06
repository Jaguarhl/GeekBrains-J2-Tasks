package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.NightVision;

/**
 * Created by Tim on 12.07.2016.
 */
public class Nightmare extends Obstacle {

    public Nightmare(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal, boolean print) {
        if (animal instanceof NightVision) {
            NightVision nightAnimal = (NightVision) animal;
            nightAnimal.runInNight(getValue(), print);
        } else {
            animal.crossFail(print);
        }
    }

    @Override
    public String toString() {
        return "прохождение дистанции в ночное время";
    }
}