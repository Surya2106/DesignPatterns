package com.example.designpatterns.parkinglotmanagement.entity;

import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {

    private int slotId;
    private boolean isVacant;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public Slot(int slotId, boolean isVacant, VehicleType vehicleType) {
        this.slotId = slotId;
        this.isVacant = isVacant;
        this.vehicleType = vehicleType;
    }
}
