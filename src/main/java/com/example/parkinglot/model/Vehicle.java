// These represent core domain objects
package com.example.parkinglot.model;

import com.example.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Vehicle {
    // Why final? - Vehicle number and type should not change once the vehicle is created
    private final VehicleType vehicleType;
    private final String vehicleNumber;
}
