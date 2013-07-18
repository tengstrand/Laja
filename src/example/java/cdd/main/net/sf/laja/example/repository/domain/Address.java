package net.sf.laja.example.repository.domain;

import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.Zipcode;

import static net.sf.laja.example.repository.domain.AddressCreator.AddressBehaviour;

public class Address extends AddressBehaviour {
    private final Zipcode zipcode;

    public Address(AddressState state) {
        super(state);

        zipcode = new Zipcode(state.zipcode);
    }
}
