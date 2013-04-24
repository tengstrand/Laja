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
        return new DefaultAddress(state.asImmutable());
    }

    // Generated code goes here...

    public static AddressFactory createAddress() {
        return new AddressFactory();
    }

    public static AddressBuilder buildAddress() {
        return AddressBuilder.create();
    }

    public static AddressListBuilder addressList(AddressBuilder... builders) {
        return new AddressListBuilder(builders);
    }

    public static AddressSetBuilder addressSet(AddressBuilder... builders) {
        return new AddressSetBuilder(builders);
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
            return new DefaultAddress(state.asImmutable());
        }

        public AddressState getState() {
            return state.asImmutable();
        }

        public AddressMutableState getMutableState() {
            return state;
        }
    }

    public static class AddressListBuilder {
        private AddressBuilder[] builders;

        public AddressListBuilder(AddressBuilder... builders) {
            this.builders = builders;
        }

        public List<Address> asAddressList() {
            return asAddressArrayList();
        }

        public List<Address> asAddressArrayList() {
            List<Address> result = new ArrayList<Address>();

            for (AddressBuilder builder : builders) {
                result.add(builder.asAddress());
            }
            return result;
        }

        public List<AddressState> asImmutableStateList() {
            return asImmutableStateArrayList();
        }

        public List<AddressState> asImmutableStateArrayList() {
            List<AddressState> result = new ArrayList<AddressState>();

            for (AddressBuilder builder : builders) {
                result.add(builder.getState());
            }
            return result;
        }

        public List<AddressMutableState> asMutableStateList() {
            return asMutableStateArrayList();
        }


        public List<AddressMutableState> asMutableStateArrayList() {
            List<AddressMutableState> result = new ArrayList<AddressMutableState>();

            for (AddressBuilder builder : builders) {
                result.add(builder.getMutableState());
            }
            return result;
        }
    }

    public static class AddressSetBuilder {
        private AddressBuilder[] builders;

        public AddressSetBuilder(AddressBuilder... builders) {
            this.builders = builders;
        }

        public Set<Address> asAddressSet() {
            return asAddressHashSet();
        }

        public Set<Address> asAddressHashSet() {
            Set<Address> result = new HashSet<Address>();

            for (AddressBuilder builder : builders) {
                result.add(builder.asAddress());
            }
            return result;
        }

        public Set<AddressState> asImmutableStateSet() {
            return asImmutableStateHashSet();
        }

        public Set<AddressState> asImmutableStateHashSet() {
            Set<AddressState> result = new HashSet<AddressState>();

            for (AddressBuilder builder : builders) {
                result.add(builder.getState());
            }
            return result;
        }

        public Set<AddressMutableState> asMutableStateSet() {
            return asMutableStateHashSet();
        }

        public Set<AddressMutableState> asMutableStateHashSet() {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (AddressBuilder builder : builders) {
                result.add(builder.getMutableState());
            }
            return result;
        }
    }
}
