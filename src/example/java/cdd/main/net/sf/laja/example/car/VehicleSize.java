package net.sf.laja.example.car;

import net.sf.laja.example.car.state.VehicleSizeState;

import static net.sf.laja.example.car.VehicleSizeCreator.VehicleSizeBehaviour;
import static net.sf.laja.example.car.state.VehicleSizeState.LENGTH_IN_CENTIMETERS;

public class VehicleSize extends VehicleSizeBehaviour {

    public VehicleSize(VehicleSizeState state) {
        super(state);

        assertThat(state.lengthInCentimeters >= 0, LENGTH_IN_CENTIMETERS, "Length must be a positive value");
    }

    public boolean isSmall() {
        return state.lengthInCentimeters < 300;
    }

    public boolean isBig() {
        return state.lengthInCentimeters >= 400;
    }

    public boolean isNormalSize() {
        return !isSmall() && !isBig();
    }
}
