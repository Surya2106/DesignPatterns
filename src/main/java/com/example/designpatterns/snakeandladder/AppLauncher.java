package com.example.designpatterns.snakeandladder;

import com.example.designpatterns.snakeandladder.entity.*;
import com.example.designpatterns.snakeandladder.exception.GameAlreadyStartedException;

import java.util.ArrayList;
import java.util.List;

import static com.example.designpatterns.snakeandladder.enums.SpecialEntityType.LADDER;
import static com.example.designpatterns.snakeandladder.enums.SpecialEntityType.SNAKE;

public class AppLauncher {
    
    public static void main(String[] args) throws GameAlreadyStartedException {
        Dice dice = new Dice(6);
        SpecialEntity ladder1 = new Ladder(5, 20, LADDER);
        SpecialEntity ladder2 = new Ladder(4, 17, LADDER);
        SpecialEntity ladder3 = new Ladder(11, 23, LADDER);

        SpecialEntity snake1 = new Snake(24, 2, SNAKE);
        SpecialEntity snake2 = new Snake(21, 11, SNAKE);
        SpecialEntity snake3 = new Snake(10, 7, SNAKE);

        Board board = new Board(5);
        board.addSpecialEntity(ladder1);
        board.addSpecialEntity(ladder2);
        board.addSpecialEntity(ladder3);
        
        board.addSpecialEntity(snake1);
        board.addSpecialEntity(snake2);
        board.addSpecialEntity(snake3);
        
        
        Game game = new Game(dice, board);
        
        Player player1 = new Player("Abbott");
        Player player2 = new Player("Bob");
        Player player3 = new Player("Carol");
        
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        
        game.addPlayers(playerList);
        
        game.launchGame();
    }
}
