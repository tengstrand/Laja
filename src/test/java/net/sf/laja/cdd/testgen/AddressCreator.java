package net.sf.laja.cdd.testgen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.testgen.state.AddressState;
import net.sf.laja.cdd.validator.ValidationErrors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.testgen.state.AddressState.*;

@Creator
public class AddressCreator implements AddressCreatorMaker {
    private final AddressMutableState state;

    public Address asAddress() {
        return asAddress(AddressType.REGULAR);
    }

    public Address asAddress(int protectionLevel) {
        if (protectionLevel < 10) {
            return asAddress(AddressType.REGULAR);
        }
        return asAddress(AddressType.PROTECTED);
    }

    public Address asAddress(AddressType type) {
        if (type == AddressType.REGULAR) {
            return new RegularAddress(state.asImmutable());
        }
        return new ProtectedAddress(state.asImmutable());
    }

    // ===== Generated code =====

    public static AddressCreator createAddress() {
        return new AddressCreator(new AddressMutableState());
    }

    public static AddressCreator createAddressFromMap(Map address) {
        return new AddressCreator(new AddressMutableState(toAddressMutableState(address)));
    }

    public static AddressBuilder buildAddress() {
        return new AddressBuilder();
    }

    public static AddressBuilder buildAddressFromMap(Map address) {
        return new AddressBuilder(new AddressMutableState(toAddressMutableState(address)));
    }

    public static AddressStringBuilder buildAddressFromStrings() {
        return new AddressStringBuilder();
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

    public static AddressMapEntryBuilder createAddressEntry(Object key, AddressCreator creator) {
        return new AddressMapEntryBuilder(key, creator);
    }

    public static AddressMapEntryBuilder createAddressEntry(Object key, AddressBuilder builder) {
        return new AddressMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public AddressCreator(AddressMutableState state) {
        this.state = state;
    }

    public AddressState asState() {
        return state.asImmutable();
    }

    public AddressMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public AddressStringState asStringState() {
        return state.asStringState();
    }

    public AddressStringState asStringState(StringStateConverter stateConverter) {
        return state.asStringState(stateConverter);
    }

    // --- With methods ---

    public AddressCreator withId(int id) {
        state.id = id;
        return this;
    }

    public AddressCreator withStreetName(String streetName) {
        state.streetName = streetName;
        return this;
    }

    public AddressCreator withCity(String city) {
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

    public ValidationErrors validate() {
        return state.validate();
    }

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof AddressCreator)) return false;

        return state.equals(((AddressCreator)that).state);
    }

    @Override public String toString() {
        return "AddressCreator" + state;
    }

    // --- Behaviour ---

    public static class AddressBehaviour {
        public final AddressState state;

        public AddressBehaviour(AddressState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidAddressStateException(errors.build());
            }
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

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidAddressStateException(errors.build());
            }
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

    public static class AddressBuilder implements AddressCreatorMaker {
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

        public Address asAddress() {
            return asAddress(AddressType.REGULAR);
        }

        public Address asAddress(int protectionLevel) {
            if (protectionLevel < 10) {
                return asAddress(AddressType.REGULAR);
            }
            return asAddress(AddressType.PROTECTED);
        }

        public Address asAddress(AddressType type) {
            if (type == AddressType.REGULAR) {
                return new RegularAddress(state.asImmutable());
            }
            return new ProtectedAddress(state.asImmutable());
        }

        public AddressState asState() {
            return state.asImmutable();
        }

        public AddressMutableState asMutableState() {
            return state;
        }

        public Map asMap() {
            return state.asMap();
        }

        public AddressStringState asStringState() {
            return state.asStringState();
        }

        public AddressStringState asStringState(StringStateConverter stateConverter) {
            return state.asStringState(stateConverter);
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate() {
            return state.validate();
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

    // --- String builder ---

    public static class AddressStringBuilder {
        private final AddressStringState state;

        public AddressStringBuilder() {
            this.state = new AddressStringState();
        }

        public AddressStringBuilder(AddressStringState state) {
            this.state = state;
        }

        public AddressStringBuilder withId(String id) { state.id = id; return this; }
        public AddressStringBuilder withStreetName(String streetName) { state.streetName = streetName; return this; }
        public AddressStringBuilder withCity(String city) { state.city = city; return this; }

        public Address asAddress() {
            return new AddressBuilder(state.asMutable()).asAddress();
        }

        public Address asAddress(int protectionLevel) {
            return new AddressBuilder(state.asMutable()).asAddress(protectionLevel);
        }

        public Address asAddress(AddressType type) {
            return new AddressBuilder(state.asMutable()).asAddress(type);
        }

        public AddressState asState() {
            return state.asImmutable();
        }

        public AddressMutableState asMutableState() {
            return state.asMutable();
        }

        public AddressStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AddressStringBuilder)) return false;

            return state.equals(((AddressStringBuilder)that).state);
        }

        @Override public String toString() {
            return "AddressStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class AddressListBuilder implements Iterable<AddressCreator> {
        private List<AddressCreator> creators;

        public AddressListBuilder(AddressCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AddressListBuilder(Collection<AddressCreator> creators) {
            this.creators = new ArrayList<AddressCreator>();
            this.creators.addAll(creators);
        }

        // asAddressList() : ImmutableList<Address>

        public ImmutableList<Address> asAddressList() {
            ImmutableList.Builder<Address> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress());
            }
            return builder.build();
        }

        // asAddressMutableList() : List<Address>

        public List<Address> asAddressMutableList() {
            List<Address> result = new ArrayList<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress());
            }
            return result;
        }

        // asAddressList(int protectionLevel) : ImmutableList<Address>

        public ImmutableList<Address> asAddressList(int protectionLevel) {
            ImmutableList.Builder<Address> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress(protectionLevel));
            }
            return builder.build();
        }

        // asAddressMutableList(int protectionLevel) : List<Address>

        public List<Address> asAddressMutableList(int protectionLevel) {
            List<Address> result = new ArrayList<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress(protectionLevel));
            }
            return result;
        }

        // asAddressList(AddressType type) : ImmutableList<Address>

        public ImmutableList<Address> asAddressList(AddressType type) {
            ImmutableList.Builder<Address> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress(type));
            }
            return builder.build();
        }

        // asAddressMutableList(AddressType type) : List<Address>

        public List<Address> asAddressMutableList(AddressType type) {
            List<Address> result = new ArrayList<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress(type));
            }
            return result;
        }

        // asStateList() : ImmutableList<AddressState>

        public ImmutableList<AddressState> asStateList() {
            ImmutableList.Builder<AddressState> builder = ImmutableList.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<AddressMutableState>

        public List<AddressMutableState> asMutableStateList() {
            List<AddressMutableState> result = new ArrayList<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<AddressCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class AddressSetBuilder implements Iterable<AddressCreator> {
        private List<AddressCreator> creators;

        public AddressSetBuilder(AddressCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AddressSetBuilder(Collection<AddressCreator> creators) {
            this.creators = new ArrayList<AddressCreator>();
            this.creators.addAll(creators);
        }

        // asAddressSet() : ImmutableSet<Address>

        public ImmutableSet<Address> asAddressSet() {
            ImmutableSet.Builder<Address> builder = ImmutableSet.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress());
            }
            return builder.build();
        }

        // asAddressMutableSet() : Set<Address>

        public Set<Address> asAddressMutableSet() {
            Set<Address> result = new HashSet<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress());
            }
            return result;
        }

        // asAddressSet(int protectionLevel) : ImmutableSet<Address>

        public ImmutableSet<Address> asAddressSet(int protectionLevel) {
            ImmutableSet.Builder<Address> builder = ImmutableSet.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress(protectionLevel));
            }
            return builder.build();
        }

        // asAddressMutableSet(int protectionLevel) : Set<Address>

        public Set<Address> asAddressMutableSet(int protectionLevel) {
            Set<Address> result = new HashSet<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress(protectionLevel));
            }
            return result;
        }

        // asAddressSet(AddressType type) : ImmutableSet<Address>

        public ImmutableSet<Address> asAddressSet(AddressType type) {
            ImmutableSet.Builder<Address> builder = ImmutableSet.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asAddress(type));
            }
            return builder.build();
        }

        // asAddressMutableSet(AddressType type) : Set<Address>

        public Set<Address> asAddressMutableSet(AddressType type) {
            Set<Address> result = new HashSet<Address>();

            for (AddressCreator creator : creators) {
                result.add(creator.asAddress(type));
            }
            return result;
        }

        // asState()

        public ImmutableSet<AddressState> asStateSet() {
            ImmutableSet.Builder<AddressState> builder = ImmutableSet.builder();

            for (AddressCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<AddressMutableState> asMutableStateSet() {
            Set<AddressMutableState> result = new HashSet<AddressMutableState>();

            for (AddressCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<AddressCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class AddressMapEntryBuilder {
        private final Object key;
        private final AddressCreatorMaker maker;

        public AddressMapEntryBuilder(Object key, AddressCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Address asAddress() {
            return maker.asAddress();
        }

        public Address asAddress(int protectionLevel) {
            return maker.asAddress(protectionLevel);
        }

        public Address asAddress(AddressType type) {
            return maker.asAddress(type);
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

        // asAddressMap() : ImmutableMap

        public ImmutableMap asAddressMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asAddress());
            }
            return builder.build();
        }

        // asAddressMutableMap() : Map

        public Map asAddressMutableMap() {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asAddress());
            }
            return result;
        }

        // asAddressMap(int protectionLevel) : ImmutableMap

        public ImmutableMap asAddressMap(int protectionLevel) {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asAddress(protectionLevel));
            }
            return builder.build();
        }

        // asAddressMutableMap(int protectionLevel) : Map

        public Map asAddressMutableMap(int protectionLevel) {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asAddress(protectionLevel));
            }
            return result;
        }

        // asAddressMap(AddressType type) : ImmutableMap

        public ImmutableMap asAddressMap(AddressType type) {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AddressMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asAddress(type));
            }
            return builder.build();
        }

        // asAddressMutableMap(AddressType type) : Map

        public Map asAddressMutableMap(AddressType type) {
            Map result = new HashMap();

            for (AddressMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asAddress(type));
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

interface AddressCreatorMaker {
    Address asAddress();
    Address asAddress(int protectionLevel);
    Address asAddress(AddressType type);

    AddressState asState();
    AddressMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
