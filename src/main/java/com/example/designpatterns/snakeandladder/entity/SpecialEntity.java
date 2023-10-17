package com.example.designpatterns.snakeandladder.entity;

import com.example.designpatterns.snakeandladder.enums.SpecialEntityType;

public abstract class SpecialEntity {

    private final int startPosition;
    private final int endPosition;
    private final SpecialEntityType specialEntityType;

    protected SpecialEntity(final int startPosition, final int endPosition, final SpecialEntityType specialEntityType) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.specialEntityType = specialEntityType;
    }

    public int getStartPosition() {
        return this.startPosition;
    }

    public int getEndPosition() {
        return this.endPosition;
    }

    public SpecialEntityType getSpecialEntityType() {
        return this.specialEntityType;
    }
}
