package net.sf.laja.cdd.state;

public class AddressStateBuilder {
    private AddressMutableState state = new AddressMutableState();
/*
    public final int id; // (id)
    public final String streetName;
    public final String city; // (optional)
  */
    public AddressStateBuilder withId(int id) {
        state.id = id;
        return this;
    }

    public AddressStateBuilder withStreetName(String streetName) {
        state.streetName = streetName;
        return this;
    }

    public AddressStateBuilder withCity(String city) {
        state.city = city;
        return this;
    }
}
