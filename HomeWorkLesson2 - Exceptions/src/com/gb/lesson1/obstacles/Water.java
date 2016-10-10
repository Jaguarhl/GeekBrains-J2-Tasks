package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Swimable;
import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.WaterFailException;

/**
 * Created by Tim on 13.07.2016.
 */
public class Water extends Obstacle {

    public Water(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) throws AnimalOutFromDistanceException, WaterFailException {
        if (animal instanceof Swimable) {
            Swimable swimableAnimal = (Swimable) animal;
            try {
                swimableAnimal.swim(getValue());
            }
            catch (AnimalOutFromDistanceException e) {
                animal.crossFail();
                throw new WaterFailException(getValue(), animal.toString());
            }
        } else {
            try {
                animal.crossFail();
            }
            catch (AnimalOutFromDistanceException e) {
                throw new WaterFailException(getValue(), animal.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "вода";
    }
}
