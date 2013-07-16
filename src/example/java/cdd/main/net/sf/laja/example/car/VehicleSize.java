package net.sf.laja.example.car;

import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSize extends VehicleSizeCreator.VehicleSizeBehaviour {
    public VehicleSize(VehicleSizeState state) {
        super(state);
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
