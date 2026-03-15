//Handles vehicle entry flow.
package com.example.parkinglot.service;

import com.example.parkinglot.factory.ParkingSpotManagerFactory;
import com.example.parkinglot.manager.ParkingSpotManager;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.spot.ParkingSpot;

import java.util.List;

public class EntryService {
    public Ticket parkVehicle(Vehicle vehicle, List<ParkingSpot> spots) {
        // In a real implementation, this method would interact with the EntryTerminal and ParkingSpotManager
        // to find an available parking spot and create a ticket for the parked vehicle.
        ParkingSpotManager manager = ParkingSpotManagerFactory.getManager(vehicle.getVehicleType(), spots);
        ParkingSpot spot = manager.allocateSpot();
        if (spot == null) {
            throw new RuntimeException("Parking Full");
        }
        manager.parkVehicle(vehicle, spot);
        return new Ticket(vehicle, spot);
    }
}
