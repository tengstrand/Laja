package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.OwnerState;
import net.sf.laja.example.car.state.OwnerStateBuilder;

public class OwnerFactory extends OwnerValueFactory {
    public OwnerFactory(OwnerState state) {
        super(state);
    }

    public OwnerFactory(OwnerState state, OwnerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
