package com.example.parkinglot.service;

import com.example.parkinglot.factory.ParkingSpotManagerFactory;
import com.example.parkinglot.manager.ParkingSpotManager;
import com.example.parkinglot.model.Ticket;

public class ExitService {
    public int calculatePrice(Ticket ticket){
        long exitTime = System.currentTimeMillis();
        long durationInMillis = exitTime - ticket.getEntryTime();
        long durationInHours = (durationInMillis / (1000 * 60 * 60)) + 1; // Round up to the next hour
        int pricePerHour = ticket.getParkingSpot().getPrice();
        return (int) (durationInHours * pricePerHour);
    }

    void removeVehicle(Ticket ticket){
        // Logic to remove vehicle from parking spot and mark it as available
        ParkingSpotManager manager = ParkingSpotManagerFactory.getManager(ticket.getVehicle().getVehicleType(), null);
        manager.freeSpot(ticket.getParkingSpot());
    }
}
