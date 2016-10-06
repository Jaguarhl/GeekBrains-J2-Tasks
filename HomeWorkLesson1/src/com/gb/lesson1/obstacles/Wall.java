package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Jumpable;

/**
 * Created by Tim on 12.07.2016.
 */
public class Wall extends Obstacle {

    public Wall(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal, boolean print) {
        if (animal instanceof Jumpable) {
            Jumpable jumpableAnimal = (Jumpable) animal;
            jumpableAnimal.jump(getValue(), print);
        } else {
            animal.crossFail(print);
        }
    }

    @Override
    public String toString() {
        return "стена";
    }
}
