package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.state.CustomerStateBuilder;

public class CustomerFactory extends CustomerEntityFactory {
    public CustomerFactory(CustomerState state) {
        super(state);
    }

    public CustomerFactory(CustomerState state, CustomerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
