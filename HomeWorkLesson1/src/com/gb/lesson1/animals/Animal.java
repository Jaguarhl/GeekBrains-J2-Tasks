package com.gb.lesson1.animals;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Animal {
    private String name;
    private boolean onDistance;
    private int maxDistance;
    public String result;

    protected Animal(String name, int maxDistance) {
        this.name = name;
        this.onDistance = true;
        this.maxDistance = maxDistance;
        this.result = "";
    }

    public void cross(int value, boolean print) {
        if (value <= maxDistance) {
            if(print) { System.out.println(name + " продолжает путь!"); }
            result += name + " продолжает путь! \n";
        } else {
            crossFail(print);
        }
    }

    public boolean isOnDistance() {
        return this.onDistance;
    }

    public void crossFail(boolean print) {
        if(print) { System.out.println(this.toString() + " сошел с дистанции :("); }
        result += this.toString() + " сошел с дистанции :( \n";
        setOnDistance(false);
    }

    public void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getResult() {
        return this.result;
    }

    public void cleanResult() {
        if(this.result != "") this.result = "";
    }
}
