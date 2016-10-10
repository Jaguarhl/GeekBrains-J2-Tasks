package com.gb.lesson1.exceptions;

/**
 * Created by Jag on 10.10.2016.
 */
public class WaterFailException extends FailException {
    final String obs = "водное препятствие";

    public WaterFailException(int value, String animal) {
        super("водное препятствие", value, animal.toString());
    }
}
