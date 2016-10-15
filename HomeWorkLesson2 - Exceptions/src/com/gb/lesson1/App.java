package com.gb.lesson1;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Cat;
import com.gb.lesson1.animals.Duck;
import com.gb.lesson1.animals.Turtle;
import com.gb.lesson1.exceptions.*;
import com.gb.lesson1.obstacles.Cross;
import com.gb.lesson1.obstacles.Wall;
import com.gb.lesson1.obstacles.Water;
import com.gb.lesson1.obstacles.Obstacle;

/**
 * Created by Tim on 12.07.2016.
 */
public class App {
    public static void main(String[] args) throws AnimalOutFromDistanceException {
        System.out.println("Готовимся к старту...");

        Animal[] animals = new Animal[3];

        animals[0] = new Cat("Мурзик");
        animals[1] = new Duck("Квака");
        animals[2] = new Turtle("Череп");

        Obstacle[] obstacles = new Obstacle[3];

        obstacles[0] = new Cross(400); //бег на 400 метров
        obstacles[1] = new Wall(3); //трехметровая стена
        obstacles[2] = new Water(200); //200 метров вплавь

        System.out.println("Старт!");

        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = obstacles[i];
            System.out.println("- Препятствие " + obstacle);
            for (int j = 0; j < animals.length; j++) {
                Animal animal = animals[j];
                if (animal.isOnDistance()) {
                    try {
                        obstacle.doIt(animal);
                    }
                    catch (FailException e) {
                        System.out.println(e.getFailInfo());
                    }
                }
            }
        }

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            if (animal.isOnDistance()) {
                System.out.println(animal.getName() + " ФИНИШИРОВАЛ!!!");
            }
        }

    }
}
