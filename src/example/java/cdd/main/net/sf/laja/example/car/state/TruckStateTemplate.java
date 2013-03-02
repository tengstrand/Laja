package net.sf.laja.example.car.state;

public class TruckStateTemplate extends TruckStateImpl {
    VehicleSizeState size;
    int weightInKilograms;
    TruckTypeState type;
    String color;
    OwnerState owner;
}
