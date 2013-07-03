package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.VehicleSizeState;

import static net.sf.laja.example.car.behaviour.VehicleSizeCreator.VehicleSizeBehaviour;

public class VehicleSize extends VehicleSizeBehaviour {
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
