package com.gb.lesson1.animals;

/**
 * Created by Tim on 12.07.2016.
 */
public class Turtle extends Animal {

    private static final int MAX_CROSS_DIST = 50;

    public Turtle(String name) {
        super(name, Turtle.MAX_CROSS_DIST);
    }

    @Override
    public String toString() {
        return "Черепаха " + getName();
    }

}
