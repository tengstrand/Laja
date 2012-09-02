package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckState;
import net.sf.laja.example.car.state.TruckStateBuilder;

public class TruckFactory extends TruckValueFactory {
    public TruckFactory(TruckState state) {
        super(state);
    }

    public TruckFactory(TruckState state, TruckStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
