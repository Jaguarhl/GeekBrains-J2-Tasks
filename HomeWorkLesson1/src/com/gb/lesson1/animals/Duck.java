package com.gb.lesson1.animals;

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
    public void jump(int height, boolean print) {
        if(height < Duck.MAX_JUMP_HEIGHT) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    @Override
    public void swim(int dist, boolean print) {
        if(dist < Duck.MAX_SWIM_DIST) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    @Override
    public String toString() {
        return "Утка " + getName();
    }

}
