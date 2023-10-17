package com.example.designpatterns.parkinglotmanagement;

import com.example.designpatterns.parkinglotmanagement.entity.Building;
import com.example.designpatterns.parkinglotmanagement.service.LinearVacantSlotStrategy;
import com.example.designpatterns.parkinglotmanagement.service.ParkingLotService;
import com.example.designpatterns.parkinglotmanagement.service.TicketService;
import com.example.designpatterns.parkinglotmanagement.service.VacantSlotStrategy;

import static com.example.designpatterns.parkinglotmanagement.enums.VehicleType.*;

public class ParkingLotManagementApplication {

    public static void main(String[] args) {

        VacantSlotStrategy linearVacantSlotStrategy = new LinearVacantSlotStrategy();
        TicketService ticketService = new TicketService();
        Building building = new Building(1, "Surya constructions", "Bunnie street", 4, 10);
        ParkingLotService parkingLotService = new ParkingLotService(linearVacantSlotStrategy, ticketService, building);


        Runnable parkingVehicleTask = () -> {
            parkingLotService.parkVehicle(TRUCK, "AP3456", "Black");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            parkingLotService.parkVehicle(TRUCK, "AP3457", "Black");
        };

        Runnable unParkingVehicleTask = () -> {
            System.out.println("\n\nrunning unParkingVehicleTask\n\n");
            parkingLotService.unParkVehicle(4);
        };
        //parkingLotService.numberOfFreeSlotsPerVehicleTypeAndFloorNo(TRUCK, 1);

        Thread thread1 = new Thread(parkingVehicleTask, "vehicle1");
        Thread thread2 = new Thread(unParkingVehicleTask, "vehicle2");

        thread1.start();
        thread2.start();

        //parkingLotService.numberOfFreeSlotsPerVehicleTypeAndFloorNo(TRUCK, 1);


        parkingLotService.parkVehicle(TRUCK, "AP3458", "Black");
        parkingLotService.parkVehicle(TRUCK, "AP3459", "Black");
        parkingLotService.parkVehicle(TRUCK, "AP34510", "Black");



        parkingLotService.numberOfSlotsPerVehicleTypeAndFloorNo(BIKE, 2);

        parkingLotService.numberOfFreeSlotsPerVehicleTypeAndFloorNo(TRUCK, 1);



    }

}
