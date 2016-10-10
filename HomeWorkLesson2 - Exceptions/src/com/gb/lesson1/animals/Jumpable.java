package com.gb.lesson1.animals;

import com.gb.lesson1.exceptions.AnimalOutFromDistanceException;
import com.gb.lesson1.exceptions.WallFailException;

/**
 * Created by Tim on 12.07.2016.
 */
public interface Jumpable {
    void jump(int height) throws AnimalOutFromDistanceException, WallFailException;
}
