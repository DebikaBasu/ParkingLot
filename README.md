
# Project Title

A brief description of what this project does and who it's for

# Parking Lot System - Low Level Design (Java)

This project demonstrates how to design a **Parking Lot System** using **Low Level Design (LLD)** concepts and **Object-Oriented Programming** in Java.

The goal of this repository is to help to understand how to structure a real-world system using:

* Object-Oriented Design
* SOLID Principles
* Design Patterns
* Clean project structure

---

# 1. Problem Statement

Design a Parking Lot system that supports:

* Vehicle entry
* Parking spot allocation
* Ticket generation
* Parking cost calculation
* Vehicle exit
* Payment processing

Supported vehicle types:

* Two Wheeler
* Four Wheeler

---

# 2. Core Entities

The system contains the following core objects:

* Vehicle
* ParkingSpot
* Ticket
* EntranceGate
* ExitGate
* ParkingSpotManager
* Payment
* CostComputation

### Relationship Overview

Vehicle → parked in → ParkingSpot
ParkingSpot → managed by → ParkingSpotManager
Ticket → contains → Vehicle + ParkingSpot + EntryTime
EntranceGate → generates ticket
ExitGate → calculates payment

---

# 3. Vehicle

Vehicle represents a vehicle entering the parking lot.

Vehicle

```
vehicleNo
vehicleType
```

VehicleType Enum:

```
TWO_WHEELER
FOUR_WHEELER
```

---

# 4. ParkingSpot (Inheritance)

ParkingSpot is a generic parking space.

ParkingSpot

```
id
isEmpty
vehicle
price
type
```

Functions:

* parkVehicle()
* removeVehicle()

### Child Classes

TwoWheelerSpot
FourWheelerSpot

Example pricing:

TwoWheelerSpot → price = 10
FourWheelerSpot → price = 20

Explanation:

ParkingSpot is a base class and specific parking spot types like TwoWheelerSpot and FourWheelerSpot extend it.

---

# 5. ParkingSpotManager

ParkingSpotManager manages parking spot allocation.

ParkingSpotManager

```
List<ParkingSpot> spots
ParkingStrategy strategy
```

Functions:

* findParkingSpace()
* parkVehicle()
* removeVehicle()

### Child Managers

TwoWheelerManager
FourWheelerManager

Reason:

Each vehicle type manages its own parking spots.

---

# 6. Strategy Pattern (Spot Allocation)

The strategy pattern is used to decide **how a parking spot is allocated**.

Example strategies:

* NearestToEntranceStrategy
* NearestToElevatorStrategy
* DefaultStrategy

Structure:

```
ParkingStrategy
      |
---------------------------
|            |            |
Nearest    Elevator      Default
```

Explanation:

The Strategy Pattern allows different parking allocation algorithms without modifying the manager class.

---

# 7. Factory Pattern (Manager Factory)

ParkingSpotManagerFactory returns the correct manager based on vehicle type.

Example:

```
getParkingSpotManager(vehicle)
```

Logic:

If vehicleType == TWO_WHEELER
→ return TwoWheelerManager

If vehicleType == FOUR_WHEELER
→ return FourWheelerManager

Explanation:

The Factory Pattern hides object creation logic from the client.

---

# 8. Ticket

Ticket represents a parking session.

Ticket

```
entryTime
vehicle
parkingSpot
```

A ticket is generated when a vehicle enters the parking lot.

---

# 9. Entrance Gate

Responsibilities:

* findParkingSpace()
* bookSpot()
* generateTicket()

### Entry Flow

Vehicle enters
↓
ParkingSpotManagerFactory
↓
Find parking spot
↓
Park vehicle
↓
Generate ticket

---

# 10. Exit Gate

Responsibilities:

* Calculate parking cost
* Process payment
* Free parking spot

### Exit Flow

Ticket scanned
↓
CostComputation
↓
Payment
↓
Remove vehicle from parking spot

---

# 11. Cost Computation (Strategy Pattern)

Cost computation uses another strategy pattern.

CostComputation

```
PricingStrategy
```

Types:

* TwoWheelerCostComputation
* FourWheelerCostComputation

Pricing strategies:

* HourlyPricing
* MinutePricing
* DefaultPricing

Example:

```
price = hours * parkingSpot.price
```

Explanation:

Pricing logic can change independently using the strategy pattern.

---

# Design Patterns Used

| Pattern       | Purpose                     |
| ------------- | --------------------------- |
| Strategy      | Spot allocation and pricing |
| Factory       | Manager creation            |
| Inheritance   | Parking spot types          |
| Encapsulation | Spot management             |

---

# Future Improvements

This system can be extended to support:

* Multiple parking floors
* Multiple entry and exit gates
* Smart nearest spot allocation using PriorityQueue
* Online payment integration
* Reservation system

---

# Author

This project is created to help to understand **Low Level System Design concepts** with a real-world example.
