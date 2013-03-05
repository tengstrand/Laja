package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;
// Zipcode

public class AddressEncapsulator implements AddressStateComparable {
    public final AddressStateBuilder builder;

    public AddressEncapsulator(AddressStateBuilder builder) {
        this.builder = builder;
    }

    public Address asAddress() {
        return (Address)builder.as(new AddressFactory.AddressFactory_());
    }

    public AddressEncapsulator withAddressId(int addressId) {
        builder.withAddressId(addressId);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
