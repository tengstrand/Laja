package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSize extends VehicleSizeFactory {
    public VehicleSize(VehicleSizeState state) {
        super(state);
    }

    // (factory)
    public VehicleSize asVehicleSize() {
        return new VehicleSize(state);
    }

    public boolean isSmall() {
        return state.getLengthInCentimeters() < 300;
    }

    public boolean isBig() {
        return state.getLengthInCentimeters() >= 400;
    }

    public boolean isNormalSize() {
        return !isSmall() && !isBig();
    }
}
