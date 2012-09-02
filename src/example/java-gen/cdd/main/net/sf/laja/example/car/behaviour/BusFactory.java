package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.BusState;
import net.sf.laja.example.car.state.BusStateBuilder;

public class BusFactory extends BusValueFactory {
    public BusFactory(BusState state) {
        super(state);
    }

    public BusFactory(BusState state, BusStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
