package net.sf.laja.cdd.example;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.annotation.Parameter;
import net.sf.laja.cdd.annotation.Parameters;
import net.sf.laja.cdd.example.PersonCreator.PersonFactory._ListOfSetOfMapOfIntegers;
import net.sf.laja.cdd.state.PersonState;
import net.sf.laja.cdd.validator.Validator;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.example.AddressCreator.*;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

@Creator
public class PersonCreator implements PersonMaker {
    private final PersonMutableState state;

    /**
     * This is a comment!
     */
    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    public SpecialPerson asSpecialPerson() {
        return new SpecialPerson(state);
    }

    public TextPerson asTextPerson() {
        return new TextPerson(state.asImmutable());
    }

    @Parameters({
            @Parameter(name = id_, signature = "PersonId personId", value = "personId.id"),
            @Parameter(name = name_, signature = "int givenName, int surname", value = "givenName + \" \" + surname"),
            @Parameter(name = hairColor_, signature = "HairColor hairColor", value = "hairColor.name()"),
            @Parameter(name = hairColor_, next = address_, method = "defaultHairColorAndChildren", value = "getDefaultHairColorAndChildren()"),
            @Parameter(name = address_, next = "*", method = "defaults", value = "getAddressDefaults(new _ListOfSetOfMapOfIntegers())"),
            @Parameter(name = address_, method = "defaultAddress", value = "getDefaultAddress()"),
            @Parameter(name = groupedAddresses_, method = "defaultGroupedAddresses"),
            @Parameter(name = listOfSetOfMapOfIntegers_, method = "defaultListOfSetOfMapOfIntegers", value = "getDefaultListOfSetOfMapOfIntegers()")
    })

    private AddressMutableState getAddressDefaults(_ListOfSetOfMapOfIntegers listOfSetOfMapOfIntegers) {
        listOfSetOfMapOfIntegers.defaultListOfSetOfMapOfIntegers();
        return getDefaultAddress();
    }

    private AddressMutableState getDefaultAddress() {
        return buildAddress().withCity("Stockholm").withStreetName("First street").asMutableState();
    }

    private List getDefaultListOfSetOfMapOfIntegers() {
        Map map1 = new HashMap();
        map1.put("a", 123);
        map1.put("b", 456);
        Set set = new HashSet(Arrays.asList(map1));
        return Arrays.asList(set);
    }

    private String getDefaultHairColorAndChildren() {
        state.children = createPersonList().asMutableStateList();
        return HairColor.RED.name();
    }

    // ===== Generated code =====

    private static final String id_ = "id";
    private static final String name_ = "name";
    private static final String birthday_ = "birthday";
    private static final String hairColor_ = "hairColor";
    private static final String children_ = "children";
    private static final String address_ = "address";
    private static final String oldAddress_ = "oldAddress";
    private static final String oldAddresses_ = "oldAddresses";
    private static final String groupedAddresses_ = "groupedAddresses";
    private static final String listOfSetOfState_ = "listOfSetOfState";
    private static final String listOfSetOfMapOfIntegers_ = "listOfSetOfMapOfIntegers";

    // --- Constructors ---

    public static PersonFactory createPerson() {
        return new PersonCreator(new PersonMutableState()).new PersonFactory();
    }

    public static PersonBuilder buildPerson() {
        return PersonBuilder.create();
    }

    public static PersonListBuilder createPersonList(PersonCreator... creators) {
        return new PersonListBuilder(creators);
    }

    public static PersonSetBuilder createPersonSet(PersonCreator... creators) {
        return new PersonSetBuilder(creators);
    }

    public static PersonMapBuilder createPersonMap(PersonMapEntryBuilder... builders) {
        return new PersonMapBuilder(builders);
    }

    public static PersonMapEntryBuilder personEntry(Object key, PersonCreator creator) {
        return new PersonMapEntryBuilder(key, creator);
    }

    public static PersonMapEntryBuilder personEntry(Object key, PersonBuilder builder) {
        return new PersonMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class PersonFactory {

        public _HairColor name(String name) {
            return new _Name().name(name);
        }

        public _HairColor name(int givenName, int surname) {
            return new _Name().name(givenName, surname);
        }

        // name
        public class _Name {
            public _HairColor name(String name) {
                state.name = name;
                return new _HairColor();
            }

            public _HairColor name(int givenName, int surname) {
                state.name = givenName + " " + surname;
                return new _HairColor();
            }
        }

        // hairColor
        public class _HairColor {
            public _Children hairColor(String hairColor) {
                state.hairColor = hairColor;
                return new _Children();
            }

            public _Children hairColor(HairColor hairColor) {
                state.hairColor = hairColor.name();
                return new _Children();
            }

            public _Address defaultHairColorAndChildren() {
                state.hairColor = getDefaultHairColorAndChildren();
                return new _Address();
            }
        }

        // children
        public class _Children {
            public _Address children(List<PersonMutableState> children) {
                state.children = children;
                return new _Address();
            }

            public _Address children(PersonCreator... creators) {
                List<PersonMutableState> children = new ArrayList<PersonMutableState>();

                for (PersonCreator creator : creators) {
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

            public PersonCreator defaults() {
                state.address = getAddressDefaults(new _ListOfSetOfMapOfIntegers());
                return new PersonCreator(state);
            }

            public _GroupedAddresses defaultAddress() {
                state.address = getDefaultAddress();
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

            public _ListOfSetOfMapOfIntegers defaultGroupedAddresses() {
                return new _ListOfSetOfMapOfIntegers();
            }
        }

        // listOfSetOfMapOfIntegers
        public class _ListOfSetOfMapOfIntegers {
            public PersonCreator listOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) {
                state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;
                return new PersonCreator(state);
            }

            public PersonCreator defaultListOfSetOfMapOfIntegers() {
                state.listOfSetOfMapOfIntegers = getDefaultListOfSetOfMapOfIntegers();
                return new PersonCreator(state);
            }
        }
    }

    // --- Constructor ---

    public PersonCreator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState asState() {
        return state.asImmutable();
    }

    public PersonMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    public PersonCreator withId(int id) {
        state.id = id;
        return this;
    }

    public PersonCreator withId(PersonId personId) {
        state.id = personId.id;
        return this;
    }

    public PersonCreator withBirthday(DateMidnight birthday) {
        state.birthday = birthday;
        return this;
    }

    public PersonCreator withBirthday(int year, int monthOfYear, int dayOfMonth) {
        state.birthday = new DateMidnight(year, monthOfYear, dayOfMonth);
        return this;
    }

    public PersonCreator withOldAddress(AddressMutableState oldAddress) {
        state.oldAddress = oldAddress;
        return this;
    }

    public PersonCreator withOldAddresses(Set<AddressMutableState> oldAddresses) {
        state.oldAddresses = oldAddresses;
        return this;
    }

    public PersonCreator withOldAddresses(AddressSetBuilder oldAddresses) {
        state.oldAddresses = oldAddresses.asMutableStateSet();
        return this;
    }

    public PersonCreator withListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) {
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

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    // --- Behaviour ---

    public static class PersonBehaviour {
        public final PersonState s;

        public PersonBehaviour(PersonState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonBehaviour)) return false;

            return s.equals(((PersonBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class PersonMutableBehaviour {
        private PersonMutableState s;

        public PersonMutableBehaviour(PersonMutableState s) {
            this.s = s;
        }

        public PersonState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof PersonMutableBehaviour)) return false;

            return s.equals(((PersonMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class PersonBuilder implements PersonMaker {
        private final PersonMutableState state;

        private PersonBuilder(PersonMutableState state) {
            this.state = state;
        }

        public static PersonBuilder create() {
            return new PersonBuilder(new PersonMutableState());
        }

        public PersonBuilder withId(int id) { state.id = id; return this; }
        public PersonBuilder withName(String name) { state.name = name; return this; }
        public PersonBuilder withBirthday(DateMidnight birthday) { state.birthday = birthday; return this; }
        public PersonBuilder withBirthday(int year, int monthOfYear, int dayOfMonth) { state.birthday = new DateMidnight(year, monthOfYear, dayOfMonth); return this; }
        public PersonBuilder withHairColor(String hairColor) { state.hairColor = hairColor; return this; }
        public PersonBuilder withChildren(List<PersonMutableState> children) { state.children = children; return this; }
        public PersonBuilder withAddress(AddressMutableState address) { state.address = address; return this; }
        public PersonBuilder withAddress(AddressCreator.AddressBuilder address) { state.address = address.asMutableState(); return this; }
        public PersonBuilder withOldAddress(AddressMutableState oldAddress) { state.oldAddress = oldAddress; return this; }
        public PersonBuilder withOldAddress(AddressCreator.AddressBuilder oldAddress) { state.oldAddress = oldAddress.asMutableState(); return this; }
        public PersonBuilder withOldAddresses(Set<AddressMutableState> oldAddresses) { state.oldAddresses = oldAddresses; return this; }
        public PersonBuilder withGroupedAddresses(Map<String,AddressMutableState> groupedAddresses) { state.groupedAddresses = groupedAddresses; return this; }
        public PersonBuilder withListOfSetOfState(List<Set<AddressMutableState>> listOfSetOfState) { state.listOfSetOfState = listOfSetOfState; return this; }
        public PersonBuilder withListOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) { state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers; return this; }

        public Person asPerson() {
            return new Person(state.asImmutable());
        }

        public SpecialPerson asSpecialPerson() {
            return new SpecialPerson(state);
        }

        public TextPerson asTextPerson() {
            return new TextPerson(state.asImmutable());
        }

        public PersonState asState() {
            return state.asImmutable();
        }

        public PersonMutableState asMutableState() {
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

    public static class PersonListBuilder {
        private PersonCreator[] creators;

        public PersonListBuilder(PersonCreator... creators) {
            this.creators = creators;
        }

        // asPersonList() : ImmutableList<Person>

        public ImmutableList<Person> asPersonList() {
            ImmutableList.Builder<Person> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableList() : List<Person>

        public List<Person> asPersonMutableList() {
            List<Person> result = new ArrayList<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // asSpecialPersonList() : ImmutableList<SpecialPerson>

        public ImmutableList<SpecialPerson> asSpecialPersonList() {
            ImmutableList.Builder<SpecialPerson> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asSpecialPerson());
            }
            return builder.build();
        }

        // asSpecialPersonMutableList() : List<SpecialPerson>

        public List<SpecialPerson> asSpecialPersonMutableList() {
            List<SpecialPerson> result = new ArrayList<SpecialPerson>();

            for (PersonCreator creator : creators) {
                result.add(creator.asSpecialPerson());
            }
            return result;
        }

        // asTextPersonList() : ImmutableList<TextPerson>

        public ImmutableList<TextPerson> asTextPersonList() {
            ImmutableList.Builder<TextPerson> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asTextPerson());
            }
            return builder.build();
        }

        // asTextPersonMutableList() : List<TextPerson>

        public List<TextPerson> asTextPersonMutableList() {
            List<TextPerson> result = new ArrayList<TextPerson>();

            for (PersonCreator creator : creators) {
                result.add(creator.asTextPerson());
            }
            return result;
        }

        // asStateList() : ImmutableList<PersonState>

        public ImmutableList<PersonState> asStateList() {
            ImmutableList.Builder<PersonState> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<PersonMutableState>

        public List<PersonMutableState> asMutableStateList() {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    // --- SetBuilder ---

    public static class PersonSetBuilder {
        private PersonCreator[] creators;

        public PersonSetBuilder(PersonCreator... creators) {
            this.creators = creators;
        }

        // asPersonSet() : ImmutableSet<Person>

        public ImmutableSet<Person> asPersonSet() {
            ImmutableSet.Builder<Person> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableSet() : Set<Person>

        public Set<Person> asPersonMutableSet() {
            Set<Person> result = new HashSet<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // asSpecialPersonSet() : ImmutableSet<SpecialPerson>

        public ImmutableSet<SpecialPerson> asSpecialPersonSet() {
            ImmutableSet.Builder<SpecialPerson> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asSpecialPerson());
            }
            return builder.build();
        }

        // asSpecialPersonMutableSet() : Set<SpecialPerson>

        public Set<SpecialPerson> asSpecialPersonMutableSet() {
            Set<SpecialPerson> result = new HashSet<SpecialPerson>();

            for (PersonCreator creator : creators) {
                result.add(creator.asSpecialPerson());
            }
            return result;
        }

        // asTextPersonSet() : ImmutableSet<TextPerson>

        public ImmutableSet<TextPerson> asTextPersonSet() {
            ImmutableSet.Builder<TextPerson> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asTextPerson());
            }
            return builder.build();
        }

        // asTextPersonMutableSet() : Set<TextPerson>

        public Set<TextPerson> asTextPersonMutableSet() {
            Set<TextPerson> result = new HashSet<TextPerson>();

            for (PersonCreator creator : creators) {
                result.add(creator.asTextPerson());
            }
            return result;
        }

        // asState()

        public ImmutableSet<PersonState> asStateSet() {
            ImmutableSet.Builder<PersonState> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<PersonMutableState> asMutableStateSet() {
            Set<PersonMutableState> result = new HashSet<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    // --- MapEntryBuilder ---

    public static class PersonMapEntryBuilder {
        private final Object key;
        private final PersonMaker maker;

        public PersonMapEntryBuilder(Object key, PersonMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Person asPerson() {
            return maker.asPerson();
        }

        public SpecialPerson asSpecialPerson() {
            return maker.asSpecialPerson();
        }

        public TextPerson asTextPerson() {
            return maker.asTextPerson();
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

        // asPersonMap() : ImmutableMap

        public ImmutableMap asPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asPerson());
            }
            return builder.build();
        }

        // asPersonMutableMap() : Map

        public Map asPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asPerson());
            }
            return result;
        }

        // asSpecialPersonMap() : ImmutableMap

        public ImmutableMap asSpecialPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asSpecialPerson());
            }
            return builder.build();
        }

        // asSpecialPersonMutableMap() : Map

        public Map asSpecialPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asSpecialPerson());
            }
            return result;
        }

        // asTextPersonMap() : ImmutableMap

        public ImmutableMap asTextPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asTextPerson());
            }
            return builder.build();
        }

        // asTextPersonMutableMap() : Map

        public Map asTextPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asTextPerson());
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

interface PersonMaker {
    Person asPerson();
    SpecialPerson asSpecialPerson();
    TextPerson asTextPerson();

    PersonState asState();
    PersonMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
