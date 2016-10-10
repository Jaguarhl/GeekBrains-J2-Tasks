package com.gb.lesson1.exceptions;

/**
 * Created by Jag on 10.10.2016.
 */
public class FailException extends AppException {
    String obstacle; // name of obstacle
    int value; // numeric value of obstacle
    String a_name; // animal name

    FailException(String obstacle, int value, String animal) {
        this.obstacle = obstacle;
        this.value = value;
        this.a_name = animal.toString();
    }

    public String getFailInfo() {
        return this.a_name + " выбыл на препятствии " + this.obstacle + " размером " + this.value;
    }
}
