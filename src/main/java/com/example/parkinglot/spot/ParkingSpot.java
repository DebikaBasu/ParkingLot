//This demonstrates Inheritance (IS-A relationship).
package com.example.parkinglot.spot;

import com.example.parkinglot.enums.SpotType;
import com.example.parkinglot.model.Vehicle;
import lombok.Getter;

@Getter
public abstract class ParkingSpot {
    private final int id;
    private final SpotType spotType;
    private boolean isOccupied;
    private Vehicle vehicle;
    private final int price;

    public ParkingSpot(int id, SpotType spotType, int price, boolean isOccupied) {
        this.id = id;
        this.spotType = spotType;
        this.price = price;
        this.isOccupied = true; // Mark the spot as occupied when it's created
    }

    public boolean isAvailable() {
        return this.isOccupied; // A spot is available if it's marked as occupied (not currently in use)
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isOccupied = true;
    }
}
