package net.sf.laja.cdd.testgen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.AddressState;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;

@Creator
public class SpecialAddressCreator implements SpecialAddressCreatorMaker {
    private final AddressMutableState state;

    public Address asSpecialAddress() {
        return new SpecialAddress(state);
    }

    // ===== Generated code =====

    public static SpecialAddressCreator createSpecialAddress() {
        return new SpecialAddressCreator(new AddressMutableState());
    }

    public static AddressBuilder buildSpecialAddress() {
        return new AddressBuilder();
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

    public static AddressMapEntryBuilder createSpecialAddressEntry(Object key, SpecialAddressCreator creator) {
        return new AddressMapEntryBuilder(key, creator);
    }

    public static AddressMapEntryBuilder createSpecialAddressEntry(Object key, AddressBuilder builder) {
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

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof SpecialAddressCreator)) return false;

        return state.equals(((SpecialAddressCreator)that).state);
    }

    @Override public String toString() {
        return "SpecialAddressCreator" + state;
    }

    // --- Behaviour ---

    public static class AddressBehaviour {
        public final AddressState state;

        public AddressBehaviour(AddressState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressBehaviour)) return false;

            return state.equals(((AddressBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class AddressMutableBehaviour {
        private AddressMutableState state;

        public AddressMutableBehaviour(AddressMutableState state) {
            this.state = state;
        }

        public AddressState state() {
            return state.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressMutableBehaviour)) return false;

            return state.equals(((AddressMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class AddressBuilder implements SpecialAddressCreatorMaker {
        private final AddressMutableState state;

        public AddressBuilder() {
            this.state = new AddressMutableState();
        }

        public AddressBuilder(AddressMutableState state) {
            this.state = state;
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

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressBuilder)) return false;

            return state.equals(((AddressBuilder)that).state);
        }

        @Override public String toString() {
            return "AddressBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class AddressListBuilder implements Iterable<SpecialAddressCreator> {
        private List<SpecialAddressCreator> creators;

        public AddressListBuilder(SpecialAddressCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AddressListBuilder(Collection<SpecialAddressCreator> creators) {
            this.creators = new ArrayList<SpecialAddressCreator>();
            this.creators.addAll(creators);
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

        public Iterator<SpecialAddressCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class AddressSetBuilder implements Iterable<SpecialAddressCreator> {
        private List<SpecialAddressCreator> creators;

        public AddressSetBuilder(SpecialAddressCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AddressSetBuilder(Collection<SpecialAddressCreator> creators) {
            this.creators = new ArrayList<SpecialAddressCreator>();
            this.creators.addAll(creators);
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

        public Iterator<SpecialAddressCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class AddressMapEntryBuilder {
        private final Object key;
        private final SpecialAddressCreatorMaker maker;

        public AddressMapEntryBuilder(Object key, SpecialAddressCreatorMaker maker) {
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

interface SpecialAddressCreatorMaker {
    Address asSpecialAddress();

    AddressState asState();
    AddressMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
