package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;

public class AddressBuilder {
    private AddressMutableState state = new AddressMutableState();

    public static AddressBuilder build() {
        return new AddressBuilder();
    }

    public AddressBuilder withId(int id) {
        state.id = id;
        return this;
    }

    public AddressBuilder withStreetName(String streetName) {
        state.streetName = streetName;
        return this;
    }

    public AddressBuilder withCity(String city) {
        state.city = city;
        return this;
    }

    public DefaultAddress asAddress() {
        return new DefaultAddress(state.asImmutable());
    }
}
