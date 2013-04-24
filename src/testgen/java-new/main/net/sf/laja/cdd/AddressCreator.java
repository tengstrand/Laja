package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class AddressCreator {
    private final AddressMutableState state;

    public Address asAddress() {
        return new DefaultAddress(state.asState());
    }

    // Generated code goes here...

    public static AddressFactory createAddress() {
        return new AddressFactory();
    }

    public static AddressBuilder buildAddress() {
        return AddressBuilder.create();
    }

    public static AddressListBuilder createAddressList(AddressCreator... creators) {
        return new AddressListBuilder(creators);
    }

    public static AddressSetBuilder createAddressSet(AddressCreator... creators) {
        return new AddressSetBuilder(creators);
    }

    public AddressCreator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState getState() {
        return state.asState();
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
            private final AddressMutableState state = new AddressMutableState();

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
            return new AddressBuilder(new AddressMutableState());
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
            return new DefaultAddress(state.asState());
        }

        public AddressState getState() {
            return state.asState();
        }

        public AddressMutableState getMutableState() {
            return state;
        }
    }

    public static class AddressListBuilder {
        private AddressCreator[] creators;

        public AddressListBuilder(AddressCreator... creators) {
            this.creators = creators;
        }

        public List<Address> asAddressList() {
            return asAddressArrayList();
        }

        public List<Address> asAddressArrayList() {
            List<Address> result = new ArrayList<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress());
            }
            return result;
        }

        public List<AddressState> asImmutableStateList() {
            return asImmutableStateArrayList();
        }

        public List<AddressState> asImmutableStateArrayList() {
            List<AddressState> result = new ArrayList<AddressState>();

            for (AddressCreator creator : creators) {
                result.add(creator.getState());
            }
            return result;
        }

        public List<AddressMutableState> asMutableStateList() {
            return asMutableStateArrayList();
        }

        public List<AddressMutableState> asMutableStateArrayList() {
            List<AddressMutableState> result = new ArrayList<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.getMutableState());
            }
            return result;
        }
    }

    public static class AddressSetBuilder {
        private AddressCreator[] creators;

        public AddressSetBuilder(AddressCreator... creators) {
            this.creators = creators;
        }

        public Set<Address> asSet() {
            return asHashSet();
        }

        public Set<Address> asHashSet() {
            Set<Address> result = new HashSet<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress());
            }
            return result;
        }

        public Set<AddressState> asStateSet() {
            return asStateHashSet();
        }

        public Set<AddressState> asStateHashSet() {
            Set<AddressState> result = new HashSet<AddressState>();

            for (AddressCreator creator : creators) {
                result.add(creator.getState());
            }
            return result;
        }

        public Set<AddressMutableState> asMutableStateSet() {
            return asMutableStateHashSet();
        }

        public Set<AddressMutableState> asMutableStateHashSet() {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.getMutableState());
            }
            return result;
        }
    }
}
