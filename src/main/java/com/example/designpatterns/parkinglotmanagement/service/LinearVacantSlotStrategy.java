package com.example.designpatterns.parkinglotmanagement.service;

import com.example.designpatterns.parkinglotmanagement.entity.Building;
import com.example.designpatterns.parkinglotmanagement.entity.Slot;
import com.example.designpatterns.parkinglotmanagement.entity.VehicleLocation;
import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;

import java.util.Optional;

public class LinearVacantSlotStrategy implements VacantSlotStrategy {

    @Override
    public Optional<VehicleLocation> getVacantSlot(final Building building, final VehicleType vehicleType) {

        System.out.println("getVacantSlot current thread : " + Thread.currentThread());
        int numFloors = building.getNumFloors();
        int slotsPerFloor = building.getSlotsPerFloor();

        for(int floor=0;floor<numFloors; ++floor) {
            for(int slot=0; slot<slotsPerFloor; ++slot) {
                Slot currentSlot = building.getFloorList().get(floor).getSlotList().get(slot);
                if(currentSlot.getVehicleType().equals(vehicleType) && currentSlot.isVacant()) {
                    return Optional.of(new VehicleLocation(building, building.getFloorList().get(floor), currentSlot));
                }
            }
        }

        return Optional.empty();
    }
}
