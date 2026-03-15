package com.example.parkinglot.factory;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.manager.FourWheelerParkingSpotManager;
import com.example.parkinglot.manager.ParkingSpotManager;
import com.example.parkinglot.manager.TwoWheelerParkingSpotManager;
import com.example.parkinglot.spot.ParkingSpot;
import com.example.parkinglot.strategy.NearestSpotStrategy;

import java.util.List;

public class ParkingSpotManagerFactory {
    public static ParkingSpotManager getManager(VehicleType type, List<ParkingSpot>spots){
        if(type == VehicleType.TWO_WHEELER){
            return new TwoWheelerParkingSpotManager(spots, new NearestSpotStrategy());
        } else {
            return new FourWheelerParkingSpotManager(spots, new NearestSpotStrategy());
        }
    }
}
