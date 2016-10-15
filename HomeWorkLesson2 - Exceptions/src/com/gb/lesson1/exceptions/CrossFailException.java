package com.gb.lesson1.exceptions;

import com.gb.lesson1.animals.Animal;

/**
 * Created by Jag on 10.10.2016.
 */
public class CrossFailException extends FailException {
    final static String OBS = "бег по пересеченной местности";

    public CrossFailException(int value, String animal) {
        super(OBS, value, animal);
    }
}
