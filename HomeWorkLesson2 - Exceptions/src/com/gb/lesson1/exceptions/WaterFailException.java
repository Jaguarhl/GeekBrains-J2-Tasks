package com.gb.lesson1.exceptions;

/**
 * Created by Jag on 10.10.2016.
 */
public class WaterFailException extends FailException {
    final static String OBS = "водное препятствие";

    public WaterFailException(int value, String animal) {
        super(OBS, value, animal.toString());
    }
}
