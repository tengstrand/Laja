package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckTypeState;
import net.sf.laja.example.car.state.TruckTypeStateBuilder;

public class TruckTypeFactory extends TruckTypeValueFactory {
    public TruckTypeFactory(TruckTypeState state) {
        super(state);
    }

    public TruckTypeFactory(TruckTypeState state, TruckTypeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
