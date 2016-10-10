package com.gb.lesson1.animals;

import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.WallFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public class Cat extends Animal implements Jumpable {

    private static final int MAX_CROSS_DIST = 1000;

    private static final int MAX_HEIGHT = 2;

    public Cat(String name) {
        super(name, MAX_CROSS_DIST);
    }

    @Override
    public void jump(int height) throws AnimalOutFromDistanceException, WallFailException {
        if(height < Cat.MAX_HEIGHT) {
            System.out.println(getName() + " продолжает путь!");
        } else {
            crossFail();
            throw new WallFailException(height, this.toString());
        }
    }

    @Override
    public String toString() {
        return "Кот " + getName();
    }
}
