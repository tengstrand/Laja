package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.AddressStateBuilder;

public class AddressFactory extends AddressValueFactory {
    public AddressFactory(AddressState state) {
        super(state);
    }

    public AddressFactory(AddressState state, AddressStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
