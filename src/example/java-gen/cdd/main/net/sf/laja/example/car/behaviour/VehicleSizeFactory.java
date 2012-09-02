package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;

public class VehicleSizeFactory extends VehicleSizeValueFactory {
    public VehicleSizeFactory(VehicleSizeState state) {
        super(state);
    }

    public VehicleSizeFactory(VehicleSizeState state, VehicleSizeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
