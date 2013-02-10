package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.VehicleState;

public class Vehicle extends VehicleFactory {
    public Vehicle(VehicleState state) {
        super(state);
    }

    // (factory)
    public Vehicle asVehicle() {
        return new Vehicle(state);
    }
}
