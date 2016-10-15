package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Jumpable;
import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.FailException;
import com.gb.lesson1.exceptions.WallFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public class Wall extends Obstacle {

    public Wall(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) throws AnimalOutFromDistanceException, FailException {
        if (animal instanceof Jumpable) {
            Jumpable jumpableAnimal = (Jumpable) animal;
            try {
                jumpableAnimal.jump(getValue());
            }
            catch (AnimalOutFromDistanceException e) {
                animal.crossFail();
                throw new WallFailException(getValue(), animal.toString());
            }
        }
        else {
            throw new WallFailException(getValue(), animal.toString());
        }
    }

    @Override
    public String toString() {
        return "стена";
    }
}
