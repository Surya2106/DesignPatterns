package com.example.designpatterns.snakeandladder.entity;

import java.util.HashMap;

public class Board {

    private final int boardDimension;
    private final HashMap<Integer, SpecialEntity> specialEntityHashMap;

    public Board(final int boardDimension) {
        this.boardDimension = boardDimension;
        this.specialEntityHashMap = new HashMap<>();
    }

    public void addSpecialEntity(SpecialEntity specialEntity) {
        int startPosition = specialEntity.getStartPosition();
        specialEntityHashMap.put(startPosition, specialEntity);
    }

    public boolean checkIfSpecialEntity(final int currentPosition) {
        return specialEntityHashMap.containsKey(currentPosition);
    }

    public SpecialEntity getSpecialEntity(final int currentPosition) {
        if(checkIfSpecialEntity(currentPosition))
            return specialEntityHashMap.get(currentPosition);
        return null;
    }

    public int getTotalNumberOfCells() {
        return boardDimension * boardDimension;
    }
}
