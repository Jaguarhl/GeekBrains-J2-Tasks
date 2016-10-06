package com.gb.lesson1.animals;

/**
 * Created by Tim on 12.07.2016.
 */
public class NightOwl extends Animal implements Jumpable, Swimable, NightVision {

    private static final int MAX_CROSS_DIST = 500;

    private static final int MAX_JUMP_HEIGHT = 10;

    private static final int MAX_SWIM_DIST = 1000;

    private static final double MAX_CROSS_DIST_NIGHT_LESS = 0.75;


    public NightOwl(String name) {
        super(name, NightOwl.MAX_CROSS_DIST);
    }

    @Override
    public void jump(int height, boolean print) {
        if(height < NightOwl.MAX_JUMP_HEIGHT) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
       } else {
            crossFail(print);
       }
    }

    @Override
    public void swim(int dist, boolean print) {
        if(dist < NightOwl.MAX_SWIM_DIST) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    @Override
    public void runInNight(int dist, boolean print) {
        if (dist <= (int)(NightOwl.MAX_CROSS_DIST * MAX_CROSS_DIST_NIGHT_LESS)) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    @Override
    public String toString() { return "Сова " + getName(); }
}
