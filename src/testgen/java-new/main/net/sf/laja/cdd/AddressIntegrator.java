package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class AddressIntegrator {
    private final AddressMutableState state;

    public AddressIntegrator(AddressMutableState state) {
        this.state = state;
    }

    public DefaultAddress asAddress() {
        return new DefaultAddress(state.asImmutable());
    }

    // *** Generated code starts here, do not change ***

    public AddressState getState() {
        return state.asImmutable();
    }

    public AddressMutableState getMutableState() {
        return state;
    }

    public AddressIntegrator withId(int id) {
        state.id = id;
        return this;
    }

    public AddressIntegrator withCity(String city) {
        state.city = city;
        return this;
    }

    public static class AddressFactory {

        public static AddressIntegrator streetName(String streetName) {
            return new Factory().new StreetName().streetName(streetName);
        }

        private static class Factory {
            private final AddressMutableState state = new AddressMutableState();

            public class StreetName {
                public AddressIntegrator streetName(String streetName) {
                    state.streetName = streetName;
                    return new AddressIntegrator(state);
                }
            }
        }
    }

    public static class AddressBuilder {
        private AddressMutableState state = new AddressMutableState();

        public static AddressBuilder buildAddress() {
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
}
