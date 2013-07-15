package net.sf.laja.example.car;

import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSize extends VehicleSizeCreator.VehicleSizeBehaviour {
    public VehicleSize(VehicleSizeState state) {
        super(state);
    }

    public boolean isSmall() {
        return s.getLengthInCentimeters() < 300;
    }

    public boolean isBig() {
        return s.getLengthInCentimeters() >= 400;
    }

    public boolean isNormalSize() {
        return !isSmall() && !isBig();
    }
}
