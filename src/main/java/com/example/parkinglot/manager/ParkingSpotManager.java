package com.example.parkinglot.manager;

import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.spot.ParkingSpot;
import com.example.parkinglot.strategy.SpotAllocationStrategy;

import java.util.List;

public abstract class ParkingSpotManager {
    protected List<ParkingSpot> spots;
    protected SpotAllocationStrategy allocationStrategy;

    public ParkingSpotManager(List<ParkingSpot> spots, SpotAllocationStrategy strategy){
        this.spots = spots;
        this.allocationStrategy = strategy;
    }
    public ParkingSpot allocateSpot() {
        return allocationStrategy.findSpotForVehicle(spots);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        if (spot != null) {
            spot.parkVehicle(vehicle);
        }
    }
    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle();
    }

}
