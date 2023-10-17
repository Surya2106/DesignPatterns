package com.example.designpatterns.snakeandladder.entity;

import com.example.designpatterns.snakeandladder.enums.GameStatus;
import com.example.designpatterns.snakeandladder.enums.SpecialEntityType;
import com.example.designpatterns.snakeandladder.exception.GameAlreadyStartedException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private final Dice dice;
    private final Queue<Player> players;
    private final Board board;
    private GameStatus gameStatus;
    Scanner scanner = new Scanner(System.in);

    public Game(final Dice dice, final Board board) {
        this.dice = dice;
        this.board = board;
        this.players = new LinkedList<>();
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void launchGame() {

        gameStatus = GameStatus.STARTED;

        while(true) {

            Player currentPlayer = players.poll();

            assert currentPlayer != null;
            makeMove(currentPlayer);

            if(currentPlayer.getPlayerPositionOnBoard() == board.getTotalNumberOfCells()) {
                System.out.println();
                System.out.println("Congratulations!! Player " + currentPlayer.getName() + " has won the game");
                break;
            } else {
                players.add(currentPlayer);
            }
        }

        gameStatus = GameStatus.FINISHED;
    }

    public void makeMove(Player currentPlayer) {

        System.out.println();
        System.out.println("Current position of player " + currentPlayer.getName() + " is : " + currentPlayer.getPlayerPositionOnBoard());
        System.out.println("Its player " + currentPlayer.getName() + " turn. Please enter any key to roll the dice");

        char pressAnyButton = scanner.next().charAt(0);

        int rolledNumber = dice.returnNumberOnDice();
        System.out.println("Dice rolling!! " + "Number on the dice is " + rolledNumber);

        int currentPositionOfPlayer = currentPlayer.getPlayerPositionOnBoard();
        int positionAfterDiceRoll = currentPositionOfPlayer + rolledNumber;

        if(positionAfterDiceRoll > board.getTotalNumberOfCells()) {
            System.out.println("You went beyond the board dimensions!! Its next plater turn!!");
        } else {
            if(board.checkIfSpecialEntity(positionAfterDiceRoll)) {
                SpecialEntity specialEntity = board.getSpecialEntity(positionAfterDiceRoll);
                if(specialEntity.getSpecialEntityType().equals(SpecialEntityType.LADDER)) {
                    System.out.println("Hurray!! Its a ladder!! You are going up!!");
                } else {
                    System.out.println("OOPS!! Its a snake!! You are going down!!");
                }
                currentPlayer.setPlayerPositionOnBoard(specialEntity.getEndPosition());
            } else {
                currentPlayer.setPlayerPositionOnBoard(positionAfterDiceRoll);
            }
        }

        System.out.println("Player " + currentPlayer.getName() + " current position in the board after rolling the dice: "
                + currentPlayer.getPlayerPositionOnBoard());

    }

    public void addPlayers(List<Player> playerList) throws GameAlreadyStartedException {
        if(this.gameStatus.equals(GameStatus.NOT_STARTED)) {
            this.players.addAll(playerList);
        } else{
            throw new GameAlreadyStartedException("Game Already started!! Cannot add new players");
        }
    }
}
