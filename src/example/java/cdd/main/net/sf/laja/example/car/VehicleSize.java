package net.sf.laja.example.car;

import net.sf.laja.example.car.state.VehicleSizeState;

import static net.sf.laja.example.car.VehicleSizeCreator.VehicleSizeBehaviour;

public class VehicleSize extends VehicleSizeBehaviour {
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
