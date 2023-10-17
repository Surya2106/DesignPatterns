package com.example.designpatterns.parkinglotmanagement.service;

import com.example.designpatterns.parkinglotmanagement.entity.*;
import com.example.designpatterns.parkinglotmanagement.enums.VehicleType;

import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.designpatterns.parkinglotmanagement.Constants.DECREASE_FREE_SLOT_COUNT;
import static com.example.designpatterns.parkinglotmanagement.Constants.INCREASE_FREE_SLOT_COUNT;
import static com.example.designpatterns.parkinglotmanagement.util.ParkingLotUtil.updateFreeSlotCount;

public class ParkingLotService {

    private final VacantSlotStrategy vacantSlotStrategy;
    private final TicketService ticketService;
    private final Building building;
    private final ReentrantLock lock;

    public ParkingLotService(final VacantSlotStrategy vacantSlotStrategy, final TicketService ticketService, final Building building) {
        this.vacantSlotStrategy = vacantSlotStrategy;
        this.ticketService = ticketService;
        this.building = building;
        this.lock = new ReentrantLock();
    }

    public void parkVehicle(final VehicleType vehicleType, final String registrationNumber, final String color) {

        lock.lock();
        try {
            Vehicle vehicle = new Vehicle(vehicleType, registrationNumber, color);
            Optional<VehicleLocation> vehicleLocation = vacantSlotStrategy.getVacantSlot(building, vehicleType);

            if(vehicleLocation.isPresent()) {
                VehicleLocation currentaVehicleLocation = vehicleLocation.get();
                currentaVehicleLocation.setVehicle(vehicle);
                System.out.println("Current thread for parking new vehicle : " + Thread.currentThread());
                parkVehicleAtSlot(vehicle, currentaVehicleLocation.getSlot());
                ticketService.generateTicket(currentaVehicleLocation);
                updateFreeSlotCount(building, currentaVehicleLocation, DECREASE_FREE_SLOT_COUNT);
                System.out.println("Vehicle successfully parked at building:" + currentaVehicleLocation.getBuilding().getBuildingId()
                        + ",  Floor:" + currentaVehicleLocation.getFloor().getFloorId() + ", Slot:" + currentaVehicleLocation.getSlot().getSlotId() + "\n");
            } else {
                System.out.println("No place to park this vehicle, PLEASE EXIT\n");
            }
        } finally {
            lock.unlock();
        }
    }

    public void unParkVehicle(final int ticketId) {

        Optional<Ticket> ticket = ticketService.getTicketById(ticketId);

        if(ticket.isPresent()) {
            Ticket currentTicket = ticket.get();
            VehicleLocation vehicleLocation = currentTicket.getVehicleLocation();
            unParkVehicleAtSlot(vehicleLocation.getSlot());
            currentTicket.setExitTime(new Date(Instant.now().toEpochMilli()));
            updateFreeSlotCount(building, vehicleLocation, INCREASE_FREE_SLOT_COUNT);
            System.out.println("Vehicle successfully unParked at building:" + vehicleLocation.getBuilding().getBuildingId()
                    + ",  Floor:" + vehicleLocation.getFloor().getFloorId() + ", Slot:" + vehicleLocation.getSlot().getSlotId() + "\n");
        } else {
            System.out.println("Incorrect ticketId entered!! Please check and enter the correct ticketId\n");
        }
    }

    public void numberOfSlotsPerVehicleTypeAndFloorNo(final VehicleType vehicleType, final int floorId) {

        if(floorId > building.getNumFloors() || floorId<=0) {
            System.out.println("Incorrect floorId entered. There are only " + building.getNumFloors() + " in the building\n\n");
            return;
        }

        Map<VehicleType, Integer> vehicleTypeIntegerMap = building.getNumberOfSlotsPerVehicleTypeAndFloorNumber().get(floorId);
        final int numberOfSlots = vehicleTypeIntegerMap.getOrDefault(vehicleType, 0);

        System.out.println("Number of slots available per vehicle and floor number : " + numberOfSlots+ "\n\n");
    }


    public void numberOfFreeSlotsPerVehicleTypeAndFloorNo(final VehicleType vehicleType, final int floorId) {

        if(floorId > building.getNumFloors() || floorId<=0) {
            System.out.println("Incorrect floorId entered. There are only " + building.getNumFloors() + " in the building\n\n");
            return;
        }

        Map<VehicleType, Integer> vehicleTypeIntegerMap = building.getNumberOfFreeSlotsPerVehicleTypeAndFloorNumber().get(floorId);
        final int numberOfSlots = vehicleTypeIntegerMap.getOrDefault(vehicleType, 0);

        System.out.println("Number of free slots available per vehicle and floor number : " + numberOfSlots + "\n\n");
    }




    private void parkVehicleAtSlot(final Vehicle vehicle, final Slot parkedSlot) {
        System.out.println("parkVehicleAtSlot : " + Thread.currentThread());
        parkedSlot.setVehicle(vehicle);
        parkedSlot.setVacant(false);
    }

    private void unParkVehicleAtSlot(final Slot parkedSlot) {
        parkedSlot.setVacant(true);
    }
}
