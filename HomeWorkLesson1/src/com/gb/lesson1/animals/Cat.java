package com.gb.lesson1.animals;

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
    public void jump(int height, boolean print) {
        if(height < Cat.MAX_HEIGHT) {
            if(print) { System.out.println(getName() + " продолжает путь!"); }
            result += getName() + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    @Override
    public String toString() {
        return "Кот " + getName();
    }
}
