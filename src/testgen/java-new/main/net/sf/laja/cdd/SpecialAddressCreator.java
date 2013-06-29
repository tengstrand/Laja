package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.AddressState;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

@Creator
public class SpecialAddressCreator implements SpecialAddressMaker {
    private final AddressMutableState state;

    public Address asSpecialAddress() {
        return new SpecialAddress(state);
    }

    // ===== Generated code =====

    private static final String id_ = "id";
    private static final String streetName_ = "streetName";
    private static final String city_ = "city";

    // --- Constructors ---

    public static SpecialAddressCreator createSpecialAddress() {
        return new SpecialAddressCreator(new AddressMutableState());
    }

    public static AddressBuilder buildSpecialAddress() {
        return AddressBuilder.create();
    }

    public static AddressListBuilder createSpecialAddressList(SpecialAddressCreator... creators) {
        return new AddressListBuilder(creators);
    }

    public static AddressSetBuilder createSpecialAddressSet(SpecialAddressCreator... creators) {
        return new AddressSetBuilder(creators);
    }

    public static AddressMapBuilder createSpecialAddressMap(AddressMapEntryBuilder... builders) {
        return new AddressMapBuilder(builders);
    }

    public static AddressMapEntryBuilder specialAddressEntry(Object key, SpecialAddressCreator creator) {
        return new AddressMapEntryBuilder(key, creator);
    }

    public static AddressMapEntryBuilder specialAddressEntry(Object key, AddressBuilder builder) {
        return new AddressMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public SpecialAddressCreator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState asState() {
        return state.asImmutable();
    }

    public AddressMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    public SpecialAddressCreator withId(int id) {
        state.id = id;
        return this;
    }

    public SpecialAddressCreator withStreetName(String streetName) {
        state.streetName = streetName;
        return this;
    }

    public SpecialAddressCreator withCity(String city) {
        state.city = city;
        return this;
    }

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    // --- Behaviour ---

    public static class AddressBehaviour {
        public final AddressState s;

        public AddressBehaviour(AddressState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressBehaviour)) return false;

            return s.equals(((AddressBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class AddressMutableBehaviour {
        private AddressMutableState s;

        public AddressMutableBehaviour(AddressMutableState s) {
            this.s = s;
        }

        public AddressState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressMutableBehaviour)) return false;

            return s.equals(((AddressMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class AddressBuilder implements SpecialAddressMaker {
        private final AddressMutableState state;

        private AddressBuilder(AddressMutableState state) {
            this.state = state;
        }

        public static AddressBuilder create() {
            return new AddressBuilder(new AddressMutableState());
        }

        public AddressBuilder withId(int id) { state.id = id; return this; }
        public AddressBuilder withStreetName(String streetName) { state.streetName = streetName; return this; }
        public AddressBuilder withCity(String city) { state.city = city; return this; }

        public Address asSpecialAddress() {
            return new SpecialAddress(state);
        }

        public AddressState asState() {
            return state.asImmutable();
        }

        public AddressMutableState asMutableState() {
            return state;
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return state.validate(validators);
        }
    }

    // --- ListBuilder ---

    public static class AddressListBuilder {
        private SpecialAddressCreator[] creators;

        public AddressListBuilder(SpecialAddressCreator... creators) {
            this.creators = creators;
        }

        // asSpecialAddressList() : ImmutableList<Address>

        public ImmutableList<Address> asSpecialAddressList() {
            ImmutableList.Builder<Address> builder = ImmutableList.builder();

            for (SpecialAddressCreator creator : creators) {
                builder.add(creator.asSpecialAddress());
            }
            return builder.build();
        }

        // asSpecialAddressMutableList() : List<Address>

        public List<Address> asSpecialAddressMutableList() {
            List<Address> result = new ArrayList<Address>();

            for (SpecialAddressCreator creator : creators) {
                result.add(creator.asSpecialAddress());
            }
            return result;
        }

        // asStateList() : ImmutableList<AddressState>

        public ImmutableList<AddressState> asStateList() {
            ImmutableList.Builder<AddressState> builder = ImmutableList.builder();

            for (SpecialAddressCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<AddressMutableState>

        public List<AddressMutableState> asMutableStateList() {
            List<AddressMutableState> result = new ArrayList<AddressMutableState>();

            for (SpecialAddressCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    // --- SetBuilder ---

    public static class AddressSetBuilder {
        private SpecialAddressCreator[] creators;

        public AddressSetBuilder(SpecialAddressCreator... creators) {
            this.creators = creators;
        }

        // asSpecialAddressSet() : ImmutableSet<Address>

        public ImmutableSet<Address> asSpecialAddressSet() {
            ImmutableSet.Builder<Address> builder = ImmutableSet.builder();

            for (SpecialAddressCreator creator : creators) {
                builder.add(creator.asSpecialAddress());
            }
            return builder.build();
        }

        // asSpecialAddressMutableSet() : Set<Address>

        public Set<Address> asSpecialAddressMutableSet() {
            Set<Address> result = new HashSet<Address>();

            for (SpecialAddressCreator creator : creators) {
                result.add(creator.asSpecialAddress());
            }
            return result;
        }

        // asState()

        public ImmutableSet<AddressState> asStateSet() {
            ImmutableSet.Builder<AddressState> builder = ImmutableSet.builder();

            for (SpecialAddressCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<AddressMutableState> asMutableStateSet() {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (SpecialAddressCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    // --- MapEntryBuilder ---

    public static class AddressMapEntryBuilder {
        private final Object key;
        private final SpecialAddressMaker maker;

        public AddressMapEntryBuilder(Object key, SpecialAddressMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Address asSpecialAddress() {
            return maker.asSpecialAddress();
        }

        public AddressState asState() {
            return maker.asState();
        }

        public AddressMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class AddressMapBuilder {
        private final AddressMapEntryBuilder[] entries;

        public AddressMapBuilder(AddressMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asSpecialAddressMap() : ImmutableMap

        public ImmutableMap asSpecialAddressMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asSpecialAddress());
            }
            return builder.build();
        }

        // asSpecialAddressMutableMap() : Map

        public Map asSpecialAddressMutableMap() {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asSpecialAddress());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface SpecialAddressMaker {
    Address asSpecialAddress();

    AddressState asState();
    AddressMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
