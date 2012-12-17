package net.sf.laja.example.car.state;

public class TruckStateTemplate extends TruckStateImpl {
    VehicleSizeState $size;
    int weightInKilograms;
    TruckTypeState type;
    String color;
    OwnerState owner;

    /**
     * We map all attributes so that this TruckState also can be used as CarState.
     */
    CarStateProjection stateCar() {
        return CarStateProjection.lengthInCentimeters(lengthInCentimeters).name(type.getTruckName()).owner(owner).color(color);
    }
}
