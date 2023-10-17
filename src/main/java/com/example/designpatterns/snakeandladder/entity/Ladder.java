package com.example.designpatterns.snakeandladder.entity;

import com.example.designpatterns.snakeandladder.enums.SpecialEntityType;

public class Ladder extends SpecialEntity{

    public Ladder(final int start, final int end, final SpecialEntityType specialEntityType) {
        super(start, end, specialEntityType);
    }
}
