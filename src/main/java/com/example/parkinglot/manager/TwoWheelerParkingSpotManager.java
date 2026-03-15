package com.example.parkinglot.manager;

import com.example.parkinglot.spot.ParkingSpot;
import com.example.parkinglot.strategy.SpotAllocationStrategy;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{
    public TwoWheelerParkingSpotManager(List<ParkingSpot> spots, SpotAllocationStrategy strategy) {
        super(spots, strategy);
    }
}
