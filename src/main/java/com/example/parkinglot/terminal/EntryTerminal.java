//Handle vehicle entry, allocate parking spot, and issue ticket.
package com.example.parkinglot.terminal;

import com.example.parkinglot.factory.ParkingSpotManagerFactory;
import com.example.parkinglot.manager.ParkingSpotManager;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.spot.ParkingSpot;

import java.util.List;

public class EntryTerminal {
    public Ticket parkVehicle(Vehicle vehicle, List<ParkingSpot> spots) {
        ParkingSpotManager manager = ParkingSpotManagerFactory.getManager(vehicle.getVehicleType(), spots);

        ParkingSpot spot = manager.allocateSpot();
        if (spot == null) {
            throw new RuntimeException("Parking Full");
        }
        manager.parkVehicle(vehicle, spot);
        return new Ticket(vehicle, spot);
    }
}
