package com.example.parkinglot.model;

import com.example.parkinglot.spot.ParkingSpot;
import lombok.Getter;

@Getter
public class Ticket {
    private final long entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = System.currentTimeMillis(); // Capture the actual entry time when the ticket is created
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }
}
