package com.example.designpatterns.snakeandladder.entity;

import java.util.Random;

public class Dice {

    private final int sidesInDice;
    private final Random randomNumber;

    public Dice(final int sidesInDice) {
        this.sidesInDice = sidesInDice;
        this.randomNumber = new Random();
    }

    public int returnNumberOnDice() {
        return randomNumber.nextInt(0, sidesInDice) + 1;
    }
}
