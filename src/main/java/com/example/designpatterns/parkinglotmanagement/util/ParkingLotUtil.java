package com.example.designpatterns.parkinglotmanagement.util;

import com.example.designpatterns.parkinglotmanagement.entity.Building;
import com.example.designpatterns.parkinglotmanagement.entity.VehicleLocation;
import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;

import java.util.Map;
import java.util.TimerTask;

import static com.example.designpatterns.parkinglotmanagement.Constants.DECREASE_FREE_SLOT_COUNT;

public class ParkingLotUtil {

    public static void updateFreeSlotCount(final Building building, final VehicleLocation vehicleLocation, final String operationType) {

        System.out.println("updateFreeSlotCount : " + Thread.currentThread());
        int floorId = vehicleLocation.getFloor().getFloorId();
        Map<VehicleType, Integer> vehicleTypeIntegerMap = building.getNumberOfFreeSlotsPerVehicleTypeAndFloorNumber().get(floorId);
        VehicleType vehicleType = vehicleLocation.getVehicle().getVehicleType();

        int change = operationType.equals(DECREASE_FREE_SLOT_COUNT) ? -1 : 1;
        vehicleTypeIntegerMap.compute(vehicleType, (key, freeSlotCount) -> (freeSlotCount != null) ? freeSlotCount + change : 0);
    }
}

