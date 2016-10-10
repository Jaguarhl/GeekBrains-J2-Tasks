package com.gb.lesson1.animals;

import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.CrossFailException;
import com.gb.lesson1.exceptions.WallFailException;
import com.gb.lesson1.exceptions.WaterFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Animal {
    private String name;
    private boolean onDistance;
    private int maxDistance;

    protected Animal(String name, int maxDistance) {
        this.name = name;
        this.onDistance = true;
        this.maxDistance = maxDistance;
    }

    public void cross(int value) throws AnimalOutFromDistanceException {
        if (value <= maxDistance) {
            System.out.println(name + " продолжает путь!");
        } else {
            crossFail();
            throw new AnimalOutFromDistanceException();
        }
    }

    public boolean isOnDistance() {
        return this.onDistance;
    }

    public void crossFail() throws AnimalOutFromDistanceException {
        setOnDistance(false);
    }

    private void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
