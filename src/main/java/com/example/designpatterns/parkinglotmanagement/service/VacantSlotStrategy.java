package com.example.designpatterns.parkinglotmanagement.service;

import com.example.designpatterns.parkinglotmanagement.entity.Building;
import com.example.designpatterns.parkinglotmanagement.entity.VehicleLocation;
import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;

import java.util.Optional;

public interface VacantSlotStrategy {

    public Optional<VehicleLocation> getVacantSlot(Building building, VehicleType vehicleType);
}
