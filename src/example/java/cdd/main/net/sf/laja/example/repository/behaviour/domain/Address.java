package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.AddressState;

public class Address extends AddressFactory {
    private final Zipcode zipcode;

    public Address(AddressState state) {
        super(state);

        zipcode = new Zipcode(state);
    }

    // (factory) (list)
    public Address asAddress() {
        return new Address(state);
    }
}
