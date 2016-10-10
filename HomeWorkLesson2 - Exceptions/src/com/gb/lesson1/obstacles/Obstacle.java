package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.CrossFailException;
import com.gb.lesson1.exceptions.WallFailException;
import com.gb.lesson1.exceptions.WaterFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Obstacle {
    private int value;

    public abstract void doIt(Animal animal) throws AnimalOutFromDistanceException, CrossFailException, WallFailException, WaterFailException;

    public Obstacle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
