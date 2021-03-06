package net.sf.laja.cdd.testgen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.testgen.state.AddressState.AddressMutableState;
import net.sf.laja.cdd.testgen.state.PersonState;
import net.sf.laja.cdd.validator.ValidationErrors;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.testgen.AddressCreator.AddressMapBuilder;
import static net.sf.laja.cdd.testgen.AddressCreator.AddressSetBuilder;
import static net.sf.laja.cdd.testgen.state.AddressState.AddressStringState;
import static net.sf.laja.cdd.testgen.state.PersonState.*;

@Creator
public class DbPersonCreator implements DbPersonCreatorMaker {
    private final PersonMutableState state;

    public DbPerson asDbPerson() {
        return new DbPerson(state.asImmutable());
    }

    // ===== Generated code =====

    public static PersonFactory createDbPerson() {
        return new DbPersonCreator(new PersonMutableState()).new PersonFactory();
    }

    public static DbPersonCreator createDbPersonFromMap(Map person) {
        return new DbPersonCreator(new PersonMutableState(toPersonMutableState(person)));
    }

    public static PersonBuilder buildDbPerson() {
        return new PersonBuilder();
    }

    public static PersonBuilder buildDbPersonFromMap(Map person) {
        return new PersonBuilder(new PersonMutableState(toPersonMutableState(person)));
    }

    public static PersonStringBuilder buildDbPersonFromStrings() {
        return new PersonStringBuilder();
    }

    public static PersonListBuilder createDbPersonList(DbPersonCreator... creators) {
        return new PersonListBuilder(creators);
    }

    public static PersonSetBuilder createDbPersonSet(DbPersonCreator... creators) {
        return new PersonSetBuilder(creators);
    }

    public static PersonMapBuilder createDbPersonMap(PersonMapEntryBuilder... builders) {
        return new PersonMapBuilder(builders);
    }

    public static PersonMapEntryBuilder createDbPersonEntry(Object key, DbPersonCreator creator) {
        return new PersonMapEntryBuilder(key, creator);
    }

    public static PersonMapEntryBuilder createDbPersonEntry(Object key, PersonBuilder builder) {
        return new PersonMapEntryBuilder(key, builder);
    }


    // --- Constructor ---

    public DbPersonCreator(PersonMutableState state) {
        this.state = state;
    }

    // --- Factory ----

    public class PersonFactory {

        public _HairColor name(String name) {
            return new _Name().name(name);
        }

        // name
        public class _Name {
            public _HairColor name(String name) {
                state.name = name;
                return new _HairColor();
            }
        }

        // hairColor
        public class _HairColor {
            public _Children hairColor(String hairColor) {
                state.hairColor = hairColor;
                return new _Children();
            }
        }

        // children
        public class _Children {
            public _Address children(Set<PersonMutableState> children) {
                state.children = children;
                return new _Address();
            }

            public _Address children(DbPersonCreator... creators) {
                Set<PersonMutableState> children = new HashSet<PersonMutableState>();

                for (DbPersonCreator creator : creators) {
                    children.add(creator.asMutableState());
                }
                state.children = children;
                return new _Address();
            }
        }

        // address
        public class _Address {
            public _GroupedAddresses address(AddressMutableState address) {
                state.address = address;
                return new _GroupedAddresses();
            }

            public _GroupedAddresses address(AddressCreator address) {
                state.address = address.asMutableState();
                return new _GroupedAddresses();
            }
        }

        // groupedAddresses
        public class _GroupedAddresses {
            public _ListOfSetOfMapOfIntegers groupedAddresses(Map<String,AddressMutableState> groupedAddresses) {
                state.groupedAddresses = groupedAddresses;
                return new _ListOfSetOfMapOfIntegers();
            }

            public _ListOfSetOfMapOfIntegers groupedAddresses(AddressMapBuilder mapBuilder) {
                state.groupedAddresses = mapBuilder.asMutableStateMap();
                return new _ListOfSetOfMapOfIntegers();
            }
        }

        // listOfSetOfMapOfIntegers
        public class _ListOfSetOfMapOfIntegers {
            public DbPersonCreator listOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) {
                state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;
                return new DbPersonCreator(state);
            }
        }
    }

    public PersonState asState() {
        return state.asImmutable();
    }

    public PersonMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public PersonStringState asStringState() {
        return state.asStringState();
    }

    public PersonStringState asStringState(StringStateConverter stateConverter) {
        return state.asStringState(stateConverter);
    }

    // --- With methods ---

    public DbPersonCreator withId(int id) {
        state.id = id;
        return this;
    }

    public DbPersonCreator withDateOfBirth(LocalDate dateOfBirth) {
        state.dateOfBirth = dateOfBirth;
        return this;
    }

    public DbPersonCreator withDateOfBirth(int year, int monthOfYear, int dayOfMonth) {
        state.dateOfBirth = new LocalDate(year, monthOfYear, dayOfMonth);
        return this;
    }

    public DbPersonCreator withOldAddress(AddressMutableState oldAddress) {
        state.oldAddress = oldAddress;
        return this;
    }

    public DbPersonCreator withOldAddress(AddressCreator oldAddress) {
        state.oldAddress = oldAddress.asMutableState();
        return this;
    }

    public DbPersonCreator withOldAddresses(Set<AddressMutableState> oldAddresses) {
        state.oldAddresses = oldAddresses;
        return this;
    }

    public DbPersonCreator withOldAddresses(AddressSetBuilder oldAddresses) {
        state.oldAddresses = oldAddresses.asMutableStateSet();
        return this;
    }

    public DbPersonCreator withListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) {
        state.listOfSetOfState = listOfSetOfState;
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
        if (that == null || !(that instanceof DbPersonCreator)) return false;

        return state.equals(((DbPersonCreator)that).state);
    }

    @Override public String toString() {
        return "DbPersonCreator" + state;
    }

    // --- Behaviour ---

    public static class PersonBehaviour {
        public final PersonState state;

        public PersonBehaviour(PersonState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidPersonStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonBehaviour)) return false;

            return state.equals(((PersonBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class PersonMutableBehaviour {
        private PersonMutableState state;

        public PersonMutableBehaviour(PersonMutableState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidPersonStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonMutableBehaviour)) return false;

            return state.equals(((PersonMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class PersonBuilder implements DbPersonCreatorMaker {
        private final PersonMutableState state;

        public PersonBuilder() {
            this.state = new PersonMutableState();
        }

        public PersonBuilder(PersonMutableState state) {
            this.state = state;
        }

        public PersonBuilder withId(int id) { state.id = id; return this; }
        public PersonBuilder withName(String name) { state.name = name; return this; }
        public PersonBuilder withDateOfBirth(LocalDate dateOfBirth) { state.dateOfBirth = dateOfBirth; return this; }
        public PersonBuilder withDateOfBirth(int year, int monthOfYear, int dayOfMonth) { state.dateOfBirth = new LocalDate(year, monthOfYear, dayOfMonth); return this; }
        public PersonBuilder withHairColor(String hairColor) { state.hairColor = hairColor; return this; }
        public PersonBuilder withChildren() { state.children = new HashSet<PersonMutableState>(); return this; }
        public PersonBuilder withChildren(Set<PersonMutableState> children) { state.children = children; return this; }
        public PersonBuilder withChildren(PersonSetBuilder children) { state.children = children.asMutableStateSet(); return this; }
        public PersonBuilder withAddress(AddressMutableState address) { state.address = address; return this; }
        public PersonBuilder withAddress(AddressCreator.AddressBuilder address) { state.address = address.asMutableState(); return this; }
        public PersonBuilder withOldAddress(AddressMutableState oldAddress) { state.oldAddress = oldAddress; return this; }
        public PersonBuilder withOldAddress(AddressCreator.AddressBuilder oldAddress) { state.oldAddress = oldAddress.asMutableState(); return this; }
        public PersonBuilder withOldAddresses() { state.oldAddresses = new HashSet<AddressMutableState>(); return this; }
        public PersonBuilder withOldAddresses(Set<AddressMutableState> oldAddresses) { state.oldAddresses = oldAddresses; return this; }
        public PersonBuilder withOldAddresses(AddressSetBuilder oldAddresses) { state.oldAddresses = oldAddresses.asMutableStateSet(); return this; }
        public PersonBuilder withGroupedAddresses() { state.groupedAddresses = new HashMap<String,AddressMutableState>(); return this; }
        public PersonBuilder withGroupedAddresses(Map<String,AddressMutableState> groupedAddresses) { state.groupedAddresses = groupedAddresses; return this; }
        public PersonBuilder withGroupedAddresses(AddressMapBuilder groupedAddresses) { state.groupedAddresses = groupedAddresses.asMutableStateMap(); return this; }
        public PersonBuilder withListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) { state.listOfSetOfState = listOfSetOfState; return this; }
        public PersonBuilder withListOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) { state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; return this; }

        public DbPerson asDbPerson() {
            return new DbPerson(state.asImmutable());
        }

        public PersonState asState() {
            return state.asImmutable();
        }

        public PersonMutableState asMutableState() {
            return state;
        }

        public Map asMap() {
            return state.asMap();
        }

        public PersonStringState asStringState() {
            return state.asStringState();
        }

        public PersonStringState asStringState(StringStateConverter stateConverter) {
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
            if (that == null || !(that instanceof PersonBuilder)) return false;

            return state.equals(((PersonBuilder)that).state);
        }

        @Override public String toString() {
            return "PersonBuilder" + state;
        }
    }

    // --- String builder ---

    public static class PersonStringBuilder {
        private final PersonStringState state;

        public PersonStringBuilder() {
            this.state = new PersonStringState();
        }

        public PersonStringBuilder(PersonStringState state) {
            this.state = state;
        }

        public PersonStringBuilder withId(String id) { state.id = id; return this; }
        public PersonStringBuilder withName(String name) { state.name = name; return this; }
        public PersonStringBuilder withDateOfBirth(String dateOfBirth) { state.dateOfBirth = dateOfBirth; return this; }
        public PersonStringBuilder withHairColor(String hairColor) { state.hairColor = hairColor; return this; }
        public PersonStringBuilder withChildren() { state.children = new HashSet<PersonStringState>(); return this; }
        public PersonStringBuilder withChildren(Set<PersonStringState> children) { state.children = children; return this; }
        public PersonStringBuilder withAddress(AddressStringState address) { state.address = address; return this; }
        public PersonStringBuilder withAddress(AddressCreator.AddressStringBuilder address) { state.address = address.asStringState(); return this; }
        public PersonStringBuilder withOldAddress(AddressStringState oldAddress) { state.oldAddress = oldAddress; return this; }
        public PersonStringBuilder withOldAddress(AddressCreator.AddressStringBuilder oldAddress) { state.oldAddress = oldAddress.asStringState(); return this; }
        public PersonStringBuilder withOldAddresses() { state.oldAddresses = new HashSet<AddressStringState>(); return this; }
        public PersonStringBuilder withOldAddresses(Set<AddressStringState> oldAddresses) { state.oldAddresses = oldAddresses; return this; }
        public PersonStringBuilder withGroupedAddresses() { state.groupedAddresses = new HashMap<String,AddressStringState>(); return this; }
        public PersonStringBuilder withGroupedAddresses(Map<String,AddressStringState> groupedAddresses) { state.groupedAddresses = groupedAddresses; return this; }
        public PersonStringBuilder withListOfSetOfState(List<Set<AddressStringState>> listOfSetOfState) { state.listOfSetOfState = listOfSetOfState; return this; }
        public PersonStringBuilder withListOfSetOfMapOfIntegers(List<Set<Map<String,String>>> listOfSetOfMapOfIntegers) { state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; return this; }

        public DbPerson asDbPerson() {
            return new PersonBuilder(state.asMutable()).asDbPerson();
        }

        public PersonState asState() {
            return state.asImmutable();
        }

        public PersonMutableState asMutableState() {
            return state.asMutable();
        }

        public PersonStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonStringBuilder)) return false;

            return state.equals(((PersonStringBuilder)that).state);
        }

        @Override public String toString() {
            return "PersonStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class PersonListBuilder implements Iterable<DbPersonCreator> {
        private List<DbPersonCreator> creators;

        public PersonListBuilder(DbPersonCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public PersonListBuilder(Collection<DbPersonCreator> creators) {
            this.creators = new ArrayList<DbPersonCreator>();
            this.creators.addAll(creators);
        }

        // asDbPersonList() : ImmutableList<DbPerson>

        public ImmutableList<DbPerson> asDbPersonList() {
            ImmutableList.Builder<DbPerson> builder = ImmutableList.builder();

            for (DbPersonCreator creator : creators) {
                builder.add(creator.asDbPerson());
            }
            return builder.build();
        }

        // asDbPersonMutableList() : List<DbPerson>

        public List<DbPerson> asDbPersonMutableList() {
            List<DbPerson> result = new ArrayList<DbPerson>();

            for (DbPersonCreator creator : creators) {
                result.add(creator.asDbPerson());
            }
            return result;
        }

        // asStateList() : ImmutableList<PersonState>

        public ImmutableList<PersonState> asStateList() {
            ImmutableList.Builder<PersonState> builder = ImmutableList.builder();

            for (DbPersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<PersonMutableState>

        public List<PersonMutableState> asMutableStateList() {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (DbPersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<DbPersonCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class PersonSetBuilder implements Iterable<DbPersonCreator> {
        private List<DbPersonCreator> creators;

        public PersonSetBuilder(DbPersonCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public PersonSetBuilder(Collection<DbPersonCreator> creators) {
            this.creators = new ArrayList<DbPersonCreator>();
            this.creators.addAll(creators);
        }

        // asDbPersonSet() : ImmutableSet<DbPerson>

        public ImmutableSet<DbPerson> asDbPersonSet() {
            ImmutableSet.Builder<DbPerson> builder = ImmutableSet.builder();

            for (DbPersonCreator creator : creators) {
                builder.add(creator.asDbPerson());
            }
            return builder.build();
        }

        // asDbPersonMutableSet() : Set<DbPerson>

        public Set<DbPerson> asDbPersonMutableSet() {
            Set<DbPerson> result = new HashSet<DbPerson>();

            for (DbPersonCreator creator : creators) {
                result.add(creator.asDbPerson());
            }
            return result;
        }

        // asState()

        public ImmutableSet<PersonState> asStateSet() {
            ImmutableSet.Builder<PersonState> builder = ImmutableSet.builder();

            for (DbPersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<PersonMutableState> asMutableStateSet() {
            Set<PersonMutableState> result = new HashSet<PersonMutableState>();

            for (DbPersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<DbPersonCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class PersonMapEntryBuilder {
        private final Object key;
        private final DbPersonCreatorMaker maker;

        public PersonMapEntryBuilder(Object key, DbPersonCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public DbPerson asDbPerson() {
            return maker.asDbPerson();
        }

        public PersonState asState() {
            return maker.asState();
        }

        public PersonMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class PersonMapBuilder {
        private final PersonMapEntryBuilder[] entries;

        public PersonMapBuilder(PersonMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asDbPersonMap() : ImmutableMap

        public ImmutableMap asDbPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asDbPerson());
            }
            return builder.build();
        }

        // asDbPersonMutableMap() : Map

        public Map asDbPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asDbPerson());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface DbPersonCreatorMaker {
    DbPerson asDbPerson();

    PersonState asState();
    PersonMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
