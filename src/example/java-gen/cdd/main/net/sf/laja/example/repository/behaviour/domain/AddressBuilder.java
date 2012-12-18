package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.AddressStateBuilder;
import net.sf.laja.example.repository.state.AddressStateBuilderImpl;
import net.sf.laja.example.repository.state.AddressStateImpl;

public class AddressBuilder {
    public final AddressStateBuilder builder;

    public AddressBuilder() {
        builder = AddressStateImpl.build();
    }

    public AddressBuilder(AddressState state) {
        builder = new AddressStateBuilderImpl(state);
    }

    public AddressBuilder(AddressState state, Object encapsulator) {
        builder = new AddressStateBuilderImpl(state, encapsulator);
    }

    public AddressBuilder withAddressId(int addressId) {
        builder.withAddressId(addressId);
        return this;
    }

    public AddressBuilder withStreetName(String streetName) {
        builder.withStreetName(streetName);
        return this;
    }

    public AddressBuilder withZipcode(int zipcode) {
        builder.withZipcode(zipcode);
        return this;
    }

    public AddressBuilder withCity(String city) {
        builder.withCity(city);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Address asAddress() {
        return (Address)builder.as(new AddressFactory.AddressFactory_(builder));
    }
}
