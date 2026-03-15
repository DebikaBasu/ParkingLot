package com.example.parkinglot;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.EntryService;
import com.example.parkinglot.service.ExitService;
import com.example.parkinglot.spot.FourWheelerSpot;
import com.example.parkinglot.spot.ParkingSpot;
import com.example.parkinglot.spot.TwoWheelerSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplication {

    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();

        spots.add(new TwoWheelerSpot(1));
        spots.add(new TwoWheelerSpot(2));
        spots.add(new FourWheelerSpot(3));
        spots.add(new FourWheelerSpot(4));

        Vehicle vehicle = new Vehicle(VehicleType.FOUR_WHEELER, "WB1234");

        EntryService entryService = new EntryService();

        Ticket ticket = entryService.parkVehicle(vehicle, spots);

        System.out.println("Vehicle Parked at Spot: " + ticket.getParkingSpot().getId());

        ExitService exitService = new ExitService();

        int price = exitService.calculatePrice(ticket);

        System.out.println("Parking Cost: " + price);

        exitService.calculatePrice(ticket);

        System.out.println("Vehicle Exited");
    }
}