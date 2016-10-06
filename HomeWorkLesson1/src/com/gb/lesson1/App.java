package com.gb.lesson1;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.animals.Cat;
import com.gb.lesson1.animals.Duck;
import com.gb.lesson1.animals.Turtle;
import com.gb.lesson1.animals.NightOwl;
import com.gb.lesson1.obstacles.Cross;
import com.gb.lesson1.obstacles.Wall;
import com.gb.lesson1.obstacles.Water;
import com.gb.lesson1.obstacles.Nightmare;
import com.gb.lesson1.obstacles.Obstacle;
import com.gb.lesson1.Contestation;

/**
 * Created by Tim on 12.07.2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Готовимся к старту...");

        Animal[] animals = new Animal[4];

        animals[0] = new Cat("Мурзик");
        animals[1] = new Duck("Квака");
        animals[2] = new Turtle("Череп");
        animals[3] = new NightOwl("Очкарик");

        Obstacle[] obstacles = new Obstacle[4];

        obstacles[0] = new Cross(400); //бег на 400 метров
        obstacles[1] = new Wall(3); //трехметровая стена
        obstacles[2] = new Water(200); //200 метров вплавь
        obstacles[3] = new Nightmare(300); //преодоление 300 метров ночью

        System.out.println("Старт!");

        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = obstacles[i];
            System.out.println("- Препятствие " + obstacle);
            for (int j = 0; j < animals.length; j++) {
                Animal animal = animals[j];
                if (animal.isOnDistance()) {
                    obstacle.doIt(animal, true);
                }
            }
        }

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            if (animal.isOnDistance()) {
                System.out.println(animal.toString() + " ФИНИШИРОВАЛ!!!");
            }
        }

        Contestation race = new Contestation(animals, obstacles);

        race.startRace();

        race.startObstacle(obstacles[0]);

        race.whoCompletedObstacle(obstacles[2]);
    }
}
