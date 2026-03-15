//Used for spot allocation logic
package com.example.parkinglot.strategy;

import com.example.parkinglot.spot.ParkingSpot;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot findSpotForVehicle(List<ParkingSpot> availableSpots);
}
