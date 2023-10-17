package com.example.designpatterns.parkinglotmanagement.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
public class Ticket {

    private int ticketId;
    private VehicleLocation vehicleLocation;
    private Date entryTime;
    private Date exitTime;

    public Ticket(VehicleLocation vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }
}
