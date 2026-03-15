package com.example.parkinglot.strategy;

import com.example.parkinglot.spot.ParkingSpot;

import java.util.List;

public class NearestSpotStrategy implements SpotAllocationStrategy {

    // This method will be implemented to find the nearest available parking spot
    // based on the vehicle type and the layout of the parking lot.

    @Override
    public ParkingSpot findSpotForVehicle(List<ParkingSpot> availableSpots) {
        for (ParkingSpot spot : availableSpots) {
            if (spot.isAvailable()) {
                return spot; // Return the first available spot (nearest)
            }
        }
        return null; // No available spots found
    }
}
