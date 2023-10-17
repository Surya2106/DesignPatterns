package com.example.designpatterns.parkinglotmanagement.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import static com.example.designpatterns.parkinglotmanagement.enums.VehicleType.*;

@Getter
@Setter
public class Building {

    private int buildingId;
    private String buildingName;
    private String buildingAddress;
    private int numFloors;
    private int slotsPerFloor;
    private List<Floor> floorList;
    private Map<Integer, Map<VehicleType, Integer>> numberOfSlotsPerVehicleTypeAndFloorNumber;
    private Map<Integer, Map<VehicleType, Integer>> numberOfFreeSlotsPerVehicleTypeAndFloorNumber;

    public Building(final int buildingId, final String buildingName, final String buildingAddress, final int numFloors, final int slotsPerFloor) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.numFloors = numFloors;
        this.slotsPerFloor = slotsPerFloor;
        this.floorList = new ArrayList<>();
        this.numberOfSlotsPerVehicleTypeAndFloorNumber = new HashMap<>();
        this.numberOfFreeSlotsPerVehicleTypeAndFloorNumber = new HashMap<>();
        createParkingLot(this, numFloors, slotsPerFloor);
    }

    public void createParkingLot(final Building building, final int numFloors, final int slotsPerFloor) {

        for(int floor=1; floor<=numFloors; ++floor) {
            List<Slot> slots = new ArrayList<>();
            Map<VehicleType, Integer> vehicleTypeIntegerMap = new HashMap<>();

            for(int slot=1; slot<=slotsPerFloor; ++slot) {
                Slot currentSlot = computeSlot(slot);
                vehicleTypeIntegerMap.compute(currentSlot.getVehicleType(), (key, oldValue) -> (oldValue==null) ? 1 : oldValue+1);
                slots.add(currentSlot);
            }
            floorList.add(new Floor(floor, slots));
            numberOfSlotsPerVehicleTypeAndFloorNumber.put(floor, vehicleTypeIntegerMap);
        }
        building.setFloorList(floorList);
        building.setNumberOfSlotsPerVehicleTypeAndFloorNumber(numberOfSlotsPerVehicleTypeAndFloorNumber);
        building.setNumberOfFreeSlotsPerVehicleTypeAndFloorNumber(numberOfSlotsPerVehicleTypeAndFloorNumber);
    }

    private Slot computeSlot(final int slotIndex) {
        return new Slot(slotIndex, true, getVehicleSlotType(slotIndex));
    }

    private VehicleType getVehicleSlotType(final int slotIndex) {
        if(slotIndex==1) {
            return TRUCK;
        } else if (slotIndex==2 || slotIndex==3) {
            return BIKE;
        }
        return CAR;
    }
}
