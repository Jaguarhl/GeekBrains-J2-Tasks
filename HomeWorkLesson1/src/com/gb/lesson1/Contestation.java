package com.gb.lesson1;

import com.gb.lesson1.animals.Animal;
import com.gb.lesson1.obstacles.Obstacle;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jag on 05.10.2016.
 */
public class Contestation {
    private static final int ARRAY_SIZE = 4;
    Animal[] players = new Animal[ARRAY_SIZE];
    Obstacle[] obstacles = new Obstacle[ARRAY_SIZE];

    public Contestation(Animal[] players, Obstacle[] obstacles) {
        this.players = players;
        this.obstacles = obstacles;
    }

    public Contestation(Animal animal1, Animal animal2, Animal animal3, Animal animal4, Obstacle obs1, Obstacle obs2, Obstacle obs3, Obstacle obs4) {
        players[0] = animal1;
        players[1] = animal2;
        players[2] = animal3;
        players[3] = animal4;
        obstacles[0] = obs1;
        obstacles[1] = obs2;
        obstacles[2] = obs3;
        obstacles[3] = obs4;
    }

    // перед стартом надо вернуть на трассу всех животных
    public void resetPlayersForRace() {
        for(int i = 0; i < players.length; i++) {
            players[i].setOnDistance(true);
            players[i].cleanResult();
        }
    }

    public void startRace() {
        // пройдём трассу с препятствиями
        System.out.println();
        System.out.println("Старт!");

        resetPlayersForRace();

        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = obstacles[i];
            System.out.println("- Препятствие " + obstacle);
            for (int j = 0; j < players.length; j++) {
                Animal animal = players[j];
                if (animal.isOnDistance()) {
                    obstacle.doIt(animal, true);
                }
            }
        }

        for (int i = 0; i < players.length; i++) {
            Animal animal = players[i];
            if (animal.isOnDistance()) {
                System.out.println(animal.toString() + " ФИНИШИРОВАЛ!!!");
            }
        }
    }

    public void startObstacle(Obstacle obstacle) {
        // пройдём конкретное препятствие
        resetPlayersForRace();
        System.out.println();
        System.out.println("Старт!");
        System.out.println("- Препятствие " + obstacle);
        for (int i = 0; i < players.length; i++) {
                obstacle.doIt(players[i], true);
        }
    }

    public void whoCompletedObstacle(Obstacle obstacle) {
        resetPlayersForRace();
        for (int i = 0; i < players.length; i++) {
            obstacle.doIt(players[i], false);
        }
        System.out.println();
        System.out.println("- РЕЗУЛЬТАТ ПРОХОЖДЕНИЯ - Препятствие " + obstacle + "\n");
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getResult());
        }
    }
}
