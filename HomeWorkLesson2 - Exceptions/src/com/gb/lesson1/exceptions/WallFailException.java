package com.gb.lesson1.exceptions;

/**
 * Created by Jag on 10.10.2016.
 */
public class WallFailException extends FailException {
    final String obs = "стена";

    public WallFailException(int value, String animal) {
        super("стена", value, animal);
    }
}
