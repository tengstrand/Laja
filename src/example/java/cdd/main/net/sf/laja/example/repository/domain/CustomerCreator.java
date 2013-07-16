package net.sf.laja.example.repository.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.repository.gui.CustomerInGui;
import net.sf.laja.example.repository.persistence.CustomerInDb;
import net.sf.laja.example.repository.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.AddressState.AddressMutableState;
import net.sf.laja.example.repository.state.CustomerState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.repository.domain.AddressCreator.AddressListBuilder;
import static net.sf.laja.example.repository.state.CustomerState.CustomerMutableState;

@Creator
public class CustomerCreator implements CustomerCreatorMaker {
    private final CustomerMutableState state;

    public Customer asCustomer() {
        return new Customer(state.asImmutable());
    }

    public CustomerMatcher asCustomerMatcher() {
        return new CustomerMatcher(state.asImmutable());
    }

    public CustomerInDb asCustomerInDb() {
        return new CustomerInDb(state.asImmutable());
    }

    public CustomerInGui asCustomerInGui() {
        return new CustomerInGui(state);
    }


    // ===== Generated code =====

    public static CustomerFactory createCustomer() {
        return new CustomerCreator(new CustomerMutableState()).new CustomerFactory();
    }

    public static CustomerBuilder buildCustomer() {
        return new CustomerBuilder();
    }

    public static CustomerListBuilder createCustomerList(CustomerCreator... creators) {
        return new CustomerListBuilder(creators);
    }

    public static CustomerSetBuilder createCustomerSet(CustomerCreator... creators) {
        return new CustomerSetBuilder(creators);
    }

    public static CustomerMapBuilder createCustomerMap(CustomerMapEntryBuilder... builders) {
        return new CustomerMapBuilder(builders);
    }

    public static CustomerMapEntryBuilder createCustomerEntry(Object key, CustomerCreator creator) {
        return new CustomerMapEntryBuilder(key, creator);
    }

    public static CustomerMapEntryBuilder createCustomerEntry(Object key, CustomerBuilder builder) {
        return new CustomerMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class CustomerFactory {

        public _GivenName ssn(long ssn) {
            return new _Ssn().ssn(ssn);
        }

        // ssn
        public class _Ssn {
            public _GivenName ssn(long ssn) {
                state.ssn = ssn;
                return new _GivenName();
            }
        }

        // givenName
        public class _GivenName {
            public _Age givenName(String givenName) {
                state.givenName = givenName;
                return new _Age();
            }
        }

        // age
        public class _Age {
            public _Address age(int age) {
                state.age = age;
                return new _Address();
            }
        }

        // address
        public class _Address {
            public CustomerCreator address(AddressMutableState address) {
                state.address = address;
                return new CustomerCreator(state);
            }

            public CustomerCreator address(AddressCreator address) {
                state.address = address.asMutableState();
                return new CustomerCreator(state);
            }
        }
    }

    // --- Constructor ---

    public CustomerCreator(CustomerMutableState state) {
        this.state = state;
    }

    public CustomerState asState() {
        return state.asImmutable();
    }

    public CustomerMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    public CustomerCreator withSurname(String surname) {
        state.surname = surname;
        return this;
    }

    public CustomerCreator withPet(String pet) {
        state.pet = pet;
        return this;
    }

    public CustomerCreator withOldAddresses(List<AddressMutableState> oldAddresses) {
        state.oldAddresses = oldAddresses;
        return this;
    }

    public CustomerCreator withOldAddresses(AddressListBuilder oldAddresses) {
        state.oldAddresses = oldAddresses.asMutableStateList();
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

    public static class CustomerBehaviour {
        public final CustomerState state;

        public CustomerBehaviour(CustomerState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CustomerBehaviour)) return false;

            return state.equals(((CustomerBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class CustomerMutableBehaviour {
        private CustomerMutableState state;

        public CustomerMutableBehaviour(CustomerMutableState state) {
            this.state = state;
        }

        public CustomerState state() {
            return state.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof CustomerMutableBehaviour)) return false;

            return state.equals(((CustomerMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class CustomerBuilder implements CustomerCreatorMaker {
        private final CustomerMutableState state;

        public CustomerBuilder() {
            this.state = new CustomerMutableState();
        }

        public CustomerBuilder(CustomerMutableState state) {
            this.state = state;
        }

        public CustomerBuilder withSsn(long ssn) { state.ssn = ssn; return this; }
        public CustomerBuilder withGivenName(String givenName) { state.givenName = givenName; return this; }
        public CustomerBuilder withSurname(String surname) { state.surname = surname; return this; }
        public CustomerBuilder withAge(int age) { state.age = age; return this; }
        public CustomerBuilder withPet(String pet) { state.pet = pet; return this; }
        public CustomerBuilder withAddress(AddressMutableState address) { state.address = address; return this; }
        public CustomerBuilder withAddress(AddressCreator.AddressBuilder address) { state.address = address.asMutableState(); return this; }
        public CustomerBuilder withOldAddresses(List<AddressMutableState> oldAddresses) { state.oldAddresses = oldAddresses; return this; }

        public Customer asCustomer() {
            return new Customer(state.asImmutable());
        }

        public CustomerMatcher asCustomerMatcher() {
            return new CustomerMatcher(state.asImmutable());
        }

        public CustomerInDb asCustomerInDb() {
            return new CustomerInDb(state.asImmutable());
        }

        public CustomerInGui asCustomerInGui() {
            return new CustomerInGui(state);
        }

        public CustomerState asState() {
            return state.asImmutable();
        }

        public CustomerMutableState asMutableState() {
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

    public static class CustomerListBuilder implements Iterable<CustomerCreator> {
        private List<CustomerCreator> creators;

        public CustomerListBuilder(CustomerCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CustomerListBuilder(Collection<CustomerCreator> creators) {
            this.creators = new ArrayList<CustomerCreator>();
            this.creators.addAll(creators);
        }

        // asCustomerList() : ImmutableList<Customer>

        public ImmutableList<Customer> asCustomerList() {
            ImmutableList.Builder<Customer> builder = ImmutableList.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomer());
            }
            return builder.build();
        }

        // asCustomerMutableList() : List<Customer>

        public List<Customer> asCustomerMutableList() {
            List<Customer> result = new ArrayList<Customer>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomer());
            }
            return result;
        }

        // asCustomerMatcherList() : ImmutableList<CustomerMatcher>

        public ImmutableList<CustomerMatcher> asCustomerMatcherList() {
            ImmutableList.Builder<CustomerMatcher> builder = ImmutableList.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerMatcher());
            }
            return builder.build();
        }

        // asCustomerMatcherMutableList() : List<CustomerMatcher>

        public List<CustomerMatcher> asCustomerMatcherMutableList() {
            List<CustomerMatcher> result = new ArrayList<CustomerMatcher>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerMatcher());
            }
            return result;
        }

        // asCustomerInDbList() : ImmutableList<CustomerInDb>

        public ImmutableList<CustomerInDb> asCustomerInDbList() {
            ImmutableList.Builder<CustomerInDb> builder = ImmutableList.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerInDb());
            }
            return builder.build();
        }

        // asCustomerInDbMutableList() : List<CustomerInDb>

        public List<CustomerInDb> asCustomerInDbMutableList() {
            List<CustomerInDb> result = new ArrayList<CustomerInDb>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerInDb());
            }
            return result;
        }

        // asCustomerInGuiList() : ImmutableList<CustomerInGui>

        public ImmutableList<CustomerInGui> asCustomerInGuiList() {
            ImmutableList.Builder<CustomerInGui> builder = ImmutableList.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerInGui());
            }
            return builder.build();
        }

        // asCustomerInGuiMutableList() : List<CustomerInGui>

        public List<CustomerInGui> asCustomerInGuiMutableList() {
            List<CustomerInGui> result = new ArrayList<CustomerInGui>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerInGui());
            }
            return result;
        }

        // asStateList() : ImmutableList<CustomerState>

        public ImmutableList<CustomerState> asStateList() {
            ImmutableList.Builder<CustomerState> builder = ImmutableList.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<CustomerMutableState>

        public List<CustomerMutableState> asMutableStateList() {
            List<CustomerMutableState> result = new ArrayList<CustomerMutableState>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<CustomerCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class CustomerSetBuilder implements Iterable<CustomerCreator> {
        private List<CustomerCreator> creators;

        public CustomerSetBuilder(CustomerCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public CustomerSetBuilder(Collection<CustomerCreator> creators) {
            this.creators = new ArrayList<CustomerCreator>();
            this.creators.addAll(creators);
        }

        // asCustomerSet() : ImmutableSet<Customer>

        public ImmutableSet<Customer> asCustomerSet() {
            ImmutableSet.Builder<Customer> builder = ImmutableSet.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomer());
            }
            return builder.build();
        }

        // asCustomerMutableSet() : Set<Customer>

        public Set<Customer> asCustomerMutableSet() {
            Set<Customer> result = new HashSet<Customer>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomer());
            }
            return result;
        }

        // asCustomerMatcherSet() : ImmutableSet<CustomerMatcher>

        public ImmutableSet<CustomerMatcher> asCustomerMatcherSet() {
            ImmutableSet.Builder<CustomerMatcher> builder = ImmutableSet.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerMatcher());
            }
            return builder.build();
        }

        // asCustomerMatcherMutableSet() : Set<CustomerMatcher>

        public Set<CustomerMatcher> asCustomerMatcherMutableSet() {
            Set<CustomerMatcher> result = new HashSet<CustomerMatcher>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerMatcher());
            }
            return result;
        }

        // asCustomerInDbSet() : ImmutableSet<CustomerInDb>

        public ImmutableSet<CustomerInDb> asCustomerInDbSet() {
            ImmutableSet.Builder<CustomerInDb> builder = ImmutableSet.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerInDb());
            }
            return builder.build();
        }

        // asCustomerInDbMutableSet() : Set<CustomerInDb>

        public Set<CustomerInDb> asCustomerInDbMutableSet() {
            Set<CustomerInDb> result = new HashSet<CustomerInDb>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerInDb());
            }
            return result;
        }

        // asCustomerInGuiSet() : ImmutableSet<CustomerInGui>

        public ImmutableSet<CustomerInGui> asCustomerInGuiSet() {
            ImmutableSet.Builder<CustomerInGui> builder = ImmutableSet.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asCustomerInGui());
            }
            return builder.build();
        }

        // asCustomerInGuiMutableSet() : Set<CustomerInGui>

        public Set<CustomerInGui> asCustomerInGuiMutableSet() {
            Set<CustomerInGui> result = new HashSet<CustomerInGui>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asCustomerInGui());
            }
            return result;
        }

        // asState()

        public ImmutableSet<CustomerState> asStateSet() {
            ImmutableSet.Builder<CustomerState> builder = ImmutableSet.builder();

            for (CustomerCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<CustomerMutableState> asMutableStateSet() {
            Set<CustomerMutableState> result = new HashSet<CustomerMutableState>();

            for (CustomerCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<CustomerCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class CustomerMapEntryBuilder {
        private final Object key;
        private final CustomerCreatorMaker maker;

        public CustomerMapEntryBuilder(Object key, CustomerCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Customer asCustomer() {
            return maker.asCustomer();
        }

        public CustomerMatcher asCustomerMatcher() {
            return maker.asCustomerMatcher();
        }

        public CustomerInDb asCustomerInDb() {
            return maker.asCustomerInDb();
        }

        public CustomerInGui asCustomerInGui() {
            return maker.asCustomerInGui();
        }

        public CustomerState asState() {
            return maker.asState();
        }

        public CustomerMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class CustomerMapBuilder {
        private final CustomerMapEntryBuilder[] entries;

        public CustomerMapBuilder(CustomerMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asCustomerMap() : ImmutableMap

        public ImmutableMap asCustomerMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CustomerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCustomer());
            }
            return builder.build();
        }

        // asCustomerMutableMap() : Map

        public Map asCustomerMutableMap() {
            Map result = new HashMap();

            for (CustomerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCustomer());
            }
            return result;
        }

        // asCustomerMatcherMap() : ImmutableMap

        public ImmutableMap asCustomerMatcherMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CustomerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCustomerMatcher());
            }
            return builder.build();
        }

        // asCustomerMatcherMutableMap() : Map

        public Map asCustomerMatcherMutableMap() {
            Map result = new HashMap();

            for (CustomerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCustomerMatcher());
            }
            return result;
        }

        // asCustomerInDbMap() : ImmutableMap

        public ImmutableMap asCustomerInDbMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CustomerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCustomerInDb());
            }
            return builder.build();
        }

        // asCustomerInDbMutableMap() : Map

        public Map asCustomerInDbMutableMap() {
            Map result = new HashMap();

            for (CustomerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCustomerInDb());
            }
            return result;
        }

        // asCustomerInGuiMap() : ImmutableMap

        public ImmutableMap asCustomerInGuiMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CustomerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asCustomerInGui());
            }
            return builder.build();
        }

        // asCustomerInGuiMutableMap() : Map

        public Map asCustomerInGuiMutableMap() {
            Map result = new HashMap();

            for (CustomerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asCustomerInGui());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (CustomerMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (CustomerMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface CustomerCreatorMaker {
    Customer asCustomer();
    CustomerMatcher asCustomerMatcher();
    CustomerInDb asCustomerInDb();
    CustomerInGui asCustomerInGui();

    CustomerState asState();
    CustomerMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
