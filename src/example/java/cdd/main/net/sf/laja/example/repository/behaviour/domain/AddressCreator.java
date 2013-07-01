package net.sf.laja.example.repository.behaviour.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.ZipcodeState.ZipcodeMutableState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.repository.state.AddressState.AddressMutableState;

@Creator
public class AddressCreator implements AddressMaker {
    private final AddressMutableState state;

    public Address asAddress() {
        return new Address(state.asImmutable());
    }

    // ===== Generated code =====

    private static final String addressId_ = "addressId";
    private static final String streetName_ = "streetName";
    private static final String zipcode_ = "zipcode";
    private static final String city_ = "city";

    // --- Constructors ---

    public static AddressFactory createAddress() {
        return new AddressCreator(new AddressMutableState()).new AddressFactory();
    }

    public static AddressBuilder buildAddress() {
        return new AddressBuilder();
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

    // --- Factory ----

    public class AddressFactory {

        public _Zipcode streetName(String streetName) {
            return new _StreetName().streetName(streetName);
        }

        // streetName
        public class _StreetName {
            public _Zipcode streetName(String streetName) {
                state.streetName = streetName;
                return new _Zipcode();
            }
        }

        // zipcode
        public class _Zipcode {
            public _City zipcode(ZipcodeMutableState zipcode) {
                state.zipcode = zipcode;
                return new _City();
            }

            public _City zipcode(ZipcodeCreator zipcode) {
                state.zipcode = zipcode.asMutableState();
                return new _City();
            }
        }

        // city
        public class _City {
            public AddressCreator city(String city) {
                state.city = city;
                return new AddressCreator(state);
            }
        }
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

    // --- With methods ---

    public AddressCreator withAddressId(int addressId) {
        state.addressId = addressId;
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

    public static class AddressBuilder implements AddressMaker {
        private final AddressMutableState state;

        public AddressBuilder() {
            this.state = new AddressMutableState();
        }

        public AddressBuilder(AddressMutableState state) {
            this.state = state;
        }

        public AddressBuilder withAddressId(int addressId) { state.addressId = addressId; return this; }
        public AddressBuilder withStreetName(String streetName) { state.streetName = streetName; return this; }
        public AddressBuilder withZipcode(ZipcodeMutableState zipcode) { state.zipcode = zipcode; return this; }
        public AddressBuilder withZipcode(ZipcodeCreator.ZipcodeBuilder zipcode) { state.zipcode = zipcode.asMutableState(); return this; }
        public AddressBuilder withCity(String city) { state.city = city; return this; }

        public Address asAddress() {
            return new Address(state.asImmutable());
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

interface AddressMaker {
    Address asAddress();

    AddressState asState();
    AddressMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
