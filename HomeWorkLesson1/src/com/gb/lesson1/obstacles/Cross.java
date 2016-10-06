package com.gb.lesson1.obstacles;

import com.gb.lesson1.animals.Animal;

/**
 * Created by Tim on 12.07.2016.
 */
public class Cross extends Obstacle {

    public Cross(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal, boolean print) {
        animal.cross(getValue(), print);
    }

    @Override
    public String toString() {
        return "бег на дистанцию";
    }
}
