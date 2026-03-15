package com.example.parkinglot.manager;

import com.example.parkinglot.spot.ParkingSpot;
import com.example.parkinglot.strategy.SpotAllocationStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager(List<ParkingSpot> spots, SpotAllocationStrategy strategy) {
        super(spots, strategy);
    }
}
