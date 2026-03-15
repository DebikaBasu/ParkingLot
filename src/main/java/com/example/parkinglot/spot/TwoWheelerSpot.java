package com.example.parkinglot.spot;

import com.example.parkinglot.enums.SpotType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(int id) {
        super(id, SpotType.TWO_WHEELER, 10); // Assuming a price of 10/- for two-wheeler spots
    }
}
