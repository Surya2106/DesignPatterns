package com.example.designpatterns.parkinglotmanagement.entity;

import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {

    private String registrationNumber;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType, String registrationNumber, String color) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}
