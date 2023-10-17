package com.example.designpatterns.parkinglotmanagement.service;

import com.example.designpatterns.parkinglotmanagement.entity.Ticket;
import com.example.designpatterns.parkinglotmanagement.entity.VehicleLocation;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketService {

    private final Map<Integer, Ticket> ticketMap;
    private int ticketId;

    public TicketService() {
        this.ticketMap = new HashMap<>();
        ticketId = 0;
    }

    public void generateTicket(final VehicleLocation vehicleLocation) {
        System.out.println("generateTicket : " + Thread.currentThread());
        Ticket newTicket = setNewTicket(vehicleLocation);
        ticketMap.put(newTicket.getTicketId(), newTicket);
        System.out.println("New ticket got generated!!! Ticket id: " + newTicket.getTicketId());
    }

    private Ticket setNewTicket(final VehicleLocation vehicleLocation) {
        Ticket newTicket = new Ticket(vehicleLocation);
        newTicket.setEntryTime(new Date(Instant.now().toEpochMilli()));
        newTicket.setTicketId(ticketId++);
        return newTicket;
    }

    public Optional<Ticket> getTicketById(final int ticketId) {
        return Optional.ofNullable(ticketMap.get(ticketId));
    }
}
