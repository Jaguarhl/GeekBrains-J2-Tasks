package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Swimable;

/**
 * Created by Tim on 13.07.2016.
 */
public class Water extends Obstacle {

    public Water(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal, boolean print) {
        if (animal instanceof Swimable) {
            Swimable swimableAnimal = (Swimable) animal;
            swimableAnimal.swim(getValue(), print);
        } else {
            animal.crossFail(print);
        }
    }

    @Override
    public String toString() {
        return "вода";
    }
}
