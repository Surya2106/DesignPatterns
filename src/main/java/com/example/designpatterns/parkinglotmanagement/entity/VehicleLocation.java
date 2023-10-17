package com.example.designpatterns.parkinglotmanagement.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLocation {

    private Vehicle vehicle;
    private Building building;
    private Floor floor;
    private Slot slot;

    public VehicleLocation(final Building building, final Floor floor, final Slot currentSlot) {
        this.building = building;
        this.floor = floor;
        this.slot = currentSlot;
    }
}
