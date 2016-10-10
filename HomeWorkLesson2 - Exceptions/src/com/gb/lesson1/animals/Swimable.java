package com.gb.lesson1.animals;

import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.WaterFailException;

/**
 * Created by Tim on 13.07.2016.
 */
public interface Swimable {
    void swim(int dist) throws AnimalOutFromDistanceException, WaterFailException;
}
