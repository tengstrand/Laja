package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

import java.util.Map;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class AddressCreator {
    private final AddressMutableState state;

    public Address asAddress() {
        return new DefaultAddress(state.asImmutable());
    }

    // Generated code goes here...

    public static AddressFactory createAddress() {
        return new AddressFactory();
    }

    public static AddressBuilder buildAddress() {
        return AddressBuilder.create();
    }

    public AddressCreator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState getState() {
        return state.asImmutable();
    }

    public AddressMutableState getMutableState() {
        return state;
    }

    public AddressCreator withId(int id) {
        state.id = id;
        return this;
    }

    public AddressCreator withCity(String city) {
        state.city = city;
        return this;
    }

    public static class AddressFactory {

        public AddressCreator streetName(String streetName) {
            return new Factory().new StreetName().streetName(streetName);
        }

        private static class Factory {
            private final AddressMutableState state = AddressMutableState.create();

            public class StreetName {
                public AddressCreator streetName(String streetName) {
                    state.streetName = streetName;
                    return new AddressCreator(state);
                }
            }
        }
    }

    public static class AddressBuilder {
        private final AddressMutableState state;

        private AddressBuilder(AddressMutableState state) {
            this.state = state;
        }

        public static AddressBuilder create() {
            return new AddressBuilder(AddressMutableState.create());
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

        public Map getData() {
            return state.asData();
        }

        public AddressState getState() {
            return state.asImmutable();
        }

        public AddressMutableState getMutableState() {
            return state;
        }
    }
}
