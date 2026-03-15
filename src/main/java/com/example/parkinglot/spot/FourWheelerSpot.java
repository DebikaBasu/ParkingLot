package com.example.parkinglot.spot;

import com.example.parkinglot.enums.SpotType;

public class FourWheelerSpot extends ParkingSpot{
    public FourWheelerSpot(int id) {
        super(id, SpotType.FOUR_WHEELER, 20); // Assuming a price of 20/- for four-wheeler spots
    }
}
