package net.sf.laja.example.repository.domain;

import net.sf.laja.example.repository.state.CustomerState;

import static net.sf.laja.example.repository.domain.CustomerCreator.CustomerBehaviour;
import static net.sf.laja.example.repository.state.CustomerState.AGE;

public class Customer extends CustomerBehaviour {
    private final Address address;

    public Customer(CustomerState state) {
        super(state);
        address = new Address(state.address);

        assertThat(state.age >= 0, AGE, "invalid-age");
    }
}
