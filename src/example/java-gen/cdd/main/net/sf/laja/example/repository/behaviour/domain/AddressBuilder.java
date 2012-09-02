package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;

public class AddressBuilder {
    public final AddressStateBuilder builder;

    public AddressBuilder() {
        builder = AddressStateImpl.build();
    }

    public AddressBuilder(AddressState state) {
        builder = AddressStateImpl.build(state);
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
