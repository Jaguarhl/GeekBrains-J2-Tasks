package com.gb.lesson1.animals;

import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.WallFailException;
import com.gb.lesson1.exceptions.WaterFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public class Duck extends Animal implements Jumpable, Swimable {

    private static final int MAX_CROSS_DIST = 500;

    private static final int MAX_JUMP_HEIGHT = 10;

    private static final int MAX_SWIM_DIST = 1000;


    public Duck(String name) {
        super(name, Duck.MAX_CROSS_DIST);
    }

    @Override
    public void jump(int height) throws AnimalOutFromDistanceException, WallFailException {
        if(height < Duck.MAX_JUMP_HEIGHT) {
            System.out.println(getName() + " продолжает путь!");
        } else {
            crossFail();
            throw new WallFailException(height, this.toString());
        }
    }

    @Override
    public void swim(int dist) throws AnimalOutFromDistanceException, WaterFailException {
        if(dist < Duck.MAX_SWIM_DIST) {
            System.out.println(getName() + " продолжает путь!");
        } else {
            crossFail();
            throw new WaterFailException(dist, this.toString());
        }
    }

    @Override
    public String toString() {
        return "Утка " + getName();
    }

}
