package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;

public class AddressEncapsulator {
    public final AddressStateBuilder builder;

    public AddressEncapsulator(AddressStateBuilder builder) {
        this.builder = builder;
    }

    public Address asAddress() {
        return (Address)builder.as(new AddressFactory.AddressFactory_(builder));
    }

    public AddressEncapsulator withAddressId(int addressId) {
        builder.withAddressId(addressId);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
