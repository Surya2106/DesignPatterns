package com.example.designpatterns.parkinglotmanagement.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Floor {

    private int floorId;
    private List<Slot> slotList;

    public Floor(int floorId, List<Slot> slotsList) {
        this.floorId = floorId;
        this.slotList = slotsList;
    }
}
