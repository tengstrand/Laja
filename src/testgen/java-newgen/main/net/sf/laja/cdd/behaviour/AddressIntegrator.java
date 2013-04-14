package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;
import net.sf.laja.cdd.state.AddressState;

public class AddressIntegrator {
    private final AddressMutableState state;

    public AddressIntegrator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState asState() {
        return state.asImmutable();
    }

    public AddressMutableState asMutableState() {
        return state;
    }

    public DefaultAddress asAddress() {
        return new DefaultAddress(state.asImmutable());
    }

    public AddressIntegrator withId(int id) {
        state.id = id;
        return this;
    }

    public AddressIntegrator withCity(String city) {
        state.city = city;
        return this;
    }
}

