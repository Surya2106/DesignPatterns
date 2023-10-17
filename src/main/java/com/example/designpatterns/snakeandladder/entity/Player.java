package com.example.designpatterns.snakeandladder.entity;

public class Player {

    private final String name;
    private int playerPositionOnBoard;

    public Player(final String name) {
        this.name = name;
        this.playerPositionOnBoard = 0;
    }

    public int getPlayerPositionOnBoard() {
        return this.playerPositionOnBoard;
    }

    public String getName() {
        return this.name;
    }

    public void setPlayerPositionOnBoard(final int updatedPositionOfPlayer) {
        this.playerPositionOnBoard = updatedPositionOfPlayer;
    }
}
