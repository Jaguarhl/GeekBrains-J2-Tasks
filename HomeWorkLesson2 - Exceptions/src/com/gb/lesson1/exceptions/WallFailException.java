package com.gb.lesson1.exceptions;

/**
 * Created by Jag on 10.10.2016.
 */
public class WallFailException extends FailException {
    final static String OBS = "стена";

    public WallFailException(int value, String animal) {
        super(OBS, value, animal);
    }
}
