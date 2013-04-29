package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.sf.laja.cdd.state.AddressState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

public class AddressCreator implements AddressMaker {
    private final AddressMutableState state;

    public Address asAddress() {
        return new RegularAddress(state.asImmutable());
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

    public static AddressMapBuilder createAddressMap(AddressMapEntryBuilder... builders) {
        return new AddressMapBuilder(builders);
    }

    public static AddressMapEntryBuilder addressEntry(Object key, AddressCreator creator) {
        return new AddressMapEntryBuilder(key, creator);
    }

    public static AddressMapEntryBuilder addressEntry(Object key, AddressBuilder builder) {
        return new AddressMapEntryBuilder(key, builder);
    }

    public AddressCreator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState asState() {
        return state.asImmutable();
    }

    public AddressMutableState asMutableState() {
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

    public static class AddressBehaviour {
        public final AddressState state;

        public AddressBehaviour(AddressState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof AddressBehaviour)) return false;
            return state.equals(((AddressBehaviour)that).state);
        }
        @Override public int hashCode() {
            return state.hashCode();
        }
        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    public static class AddressMutableBehaviour {
        private final AddressMutableState state;

        public AddressMutableBehaviour(AddressMutableState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof AddressMutableBehaviour)) return false;
            return state.equals(((AddressMutableBehaviour)that).state);
        }
        @Override public int hashCode() {
            return state.hashCode();
        }
        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
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

    public static class AddressBuilder implements AddressMaker {
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

        public Address asAddress() {
            return new RegularAddress(state.asImmutable());
        }

        public AddressState asState() {
            return state.asImmutable();
        }

        public AddressMutableState asMutableState() {
            return state;
        }
    }

    // TODO: add tests!
    public static class AddressListBuilder {
        private AddressCreator[] creators;

        public AddressListBuilder(AddressCreator... creators) {
            this.creators = creators;
        }

        public ImmutableList<Address> asList() {
            ImmutableList.Builder<Address> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress());
            }
            return builder.build();
        }

        public ImmutableList<AddressState> asStateList() {
            ImmutableList.Builder<AddressState> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        public List<Address> asMutableList() {
            List<Address> result = new ArrayList<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress());
            }
            return result;
        }

        public List<AddressMutableState> asMutableStateList() {
            List<AddressMutableState> result = new ArrayList<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.asMutableState());
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
                result.add(creator.asState());
            }
            return result;
        }

        public Set<AddressMutableState> asMutableStateSet() {
            return asMutableStateHashSet();
        }

        public Set<AddressMutableState> asMutableStateHashSet() {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    public static class AddressMapEntryBuilder {
        private final Object key;
        private final AddressMaker maker;

        public AddressMapEntryBuilder(Object key, AddressMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Address asAddress() {
            return maker.asAddress();
        }

        public AddressState asState() {
            return maker.asState();
        }

        public AddressMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    public static class AddressMapBuilder {
        private final AddressMapEntryBuilder[] entries;

        public AddressMapBuilder(AddressMapEntryBuilder... entries) {
            this.entries = entries;
        }

        public ImmutableMap asAddressMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asAddress());
            }
            return builder.build();
        }

        public Map asAddressMutableMap() {
            Map<Object,Address> result = new HashMap<Object,Address>();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asAddress());
            }
            return result;
        }

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

interface AddressMaker {
    Address asAddress();
    AddressState asState();
    AddressMutableState asMutableState();
}
