package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

@Creator
public class PersonCreator implements PersonMaker {
    private final PersonMutableState state;

    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    public SpecialPerson asSpecialPerson() {
        return new SpecialPerson(state);
    }

    public DbPerson asDbPerson() {
        return new DbPerson(state.asImmutable());
    }

    public TextPerson asTextPerson() {
        return new TextPerson(state.asImmutable());
    }

    // ===== Generated code =====

    public static PersonFactory createPerson() {
        return new PersonFactory();
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

    public PersonCreator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState asState() {
        return state.asImmutable();
    }

    public PersonMutableState asMutableState() {
        return state;
    }

    public PersonCreator withAddress(AddressMutableState address) {
        state.address = address;
        return this;
    }

    public PersonCreator withOldAddresses(AddressSetBuilder addresses) {
        state.oldAddresses = addresses.asMutableStateSet();
        return this;
    }

    public PersonCreator withGroupedAddresses(AddressMapBuilder groupedAddresses) {
        state.groupedAddresses = groupedAddresses.asMutableStateMap();
        return this;
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

    public static class PersonBehaviour {
        public final PersonState s;

        public PersonBehaviour(PersonState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof PersonBehaviour)) return false;

            return s.equals(((PersonBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

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
            if (!(that instanceof PersonMutableBehaviour)) return false;

            return s.equals(((PersonMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    public static class PersonFactory {

        public Factory.Birthday name(String name) {
            return new Factory().new Name().name(name);
        }

        private static class Factory {
            private final PersonMutableState state = new PersonMutableState();

            public class Name {
                public Birthday name(String name) {
                    state.name = name;
                    return new Birthday();
                }
            }

            public class Birthday {
                public Children birthday(int year, int month, int day) {
                    state.birthday = new DateMidnight(year, month, day);
                    return new Children();
                }

                public Children birthday(DateMidnight birthday) {
                    state.birthday = birthday;
                    return new Children();
                }
            }

            public class Children {
                public Address children(PersonCreator... creators) {
                    List<PersonMutableState> children = new ArrayList<PersonMutableState>();

                    for (PersonCreator creator : creators) {
                        children.add(creator.asMutableState());
                    }
                    state.children = children;
                    return new Address();
                }

                public Address children(List<PersonMutableState> children) {
                    state.children = children;
                    return new Address();
                }
            }

            public class Address {
                public PersonCreator defaults() {
                    defaultAddress();
                    new ListOfSetOfListOfIntegers().defaultListOfSetOfMapOfIntegers();
                    return new PersonCreator(state);
                }

                // TODO: Make sure this row is preserved when generated.
                public ListOfSetOfListOfIntegers defaultAddress() {
                    state.address = buildAddress().withCity("Stockholm").withStreetName("Street 1").asMutableState();
                    return new ListOfSetOfListOfIntegers();
                }

                public ListOfSetOfListOfIntegers address(AddressMutableState address) {
                    state.address = address;
                    return new ListOfSetOfListOfIntegers();
                }

                public ListOfSetOfListOfIntegers address(AddressCreator integrator) {
                    state.address = integrator.asMutableState();
                    return new ListOfSetOfListOfIntegers();
                }
            }

            public class ListOfSetOfListOfIntegers {
                // TODO: Make sure this row is preserved when generated.
                public PersonCreator defaultListOfSetOfMapOfIntegers() {
                    Map map1 = new HashMap();
                    map1.put("a", 123);
                    map1.put("b", 456);
                    Set set = new HashSet(Arrays.asList(map1));
                    List list = Arrays.asList(set);
                    state.listOfSetOfMapOfIntegers = list;
                    return new PersonCreator(state);
                }

                public PersonCreator listOfSetOfMapOfIntegers(List<Set<Map<String,Integer>>> listOfSetOfMapOfIntegers) {
                    state.listOfSetOfMapOfIntegers = listOfSetOfMapOfIntegers;
                    return new PersonCreator(state);
                }
            }
        }
    }

    public static class PersonBuilder implements PersonMaker {
        private final PersonMutableState state;

        private PersonBuilder(PersonMutableState state) {
            this.state = state;
        }

        public static PersonBuilder create() {
            return new PersonBuilder(new PersonMutableState());
        }

        public PersonBuilder withName(String name) {
            state.name = name;
            return this;
        }

        public PersonBuilder withBirthday(DateMidnight birthday) {
            state.birthday = birthday;
            return this;
        }

        public PersonBuilder withBirthday(int year, int month, int day) {
            state.birthday = new DateMidnight(year, month, day);
            return this;
        }

        public PersonBuilder withChildren() {
            state.children = new ArrayList<PersonMutableState>();
            return this;
        }

        public PersonBuilder withChildren(List<PersonMutableState> children) {
            state.children = children;
            return this;
        }

        public PersonBuilder withAddress(AddressMutableState address) {
            state.address = address;
            return this;
        }

        public PersonBuilder withAddress(AddressCreator.AddressBuilder address) {
            state.address = address.asMutableState();
            return this;
        }

        public PersonBuilder withOldAddresses(Set<AddressMutableState> oldAddresses) {
            state.oldAddresses = oldAddresses;
            return this;
        }

        public PersonBuilder withGroupedAddresses(Map<String, AddressMutableState> groupedAddresses) {
            state.groupedAddresses = groupedAddresses;
            return this;
        }

        public Person asPerson() {
            return new Person(state.asImmutable());
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

        public ValidationErrors validate() {
            return state.validate();
        }
    }

    public static class PersonListBuilder {
        private PersonCreator[] creators;

        public PersonListBuilder(PersonCreator... creators) {
            this.creators = creators;
        }

        // Person

        public ImmutableList<Person> asPersonList() {
            ImmutableList.Builder<Person> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        public List<Person> asPersonMutableList() {
            List<Person> result = new ArrayList<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // State

        public ImmutableList<PersonState> asStateList() {
            ImmutableList.Builder<PersonState> builder = ImmutableList.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        public List<PersonMutableState> asMutableStateList() {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

    public static class PersonSetBuilder {
        private PersonCreator[] creators;

        public PersonSetBuilder(PersonCreator... creators) {
            this.creators = creators;
        }

        // Person

        public ImmutableSet<Person> asPersonSet() {
            ImmutableSet.Builder<Person> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asPerson());
            }
            return builder.build();
        }

        public Set<Person> asPersonMutableSet() {
            Set<Person> result = new HashSet<Person>();

            for (PersonCreator creator : creators) {
                result.add(creator.asPerson());
            }
            return result;
        }

        // TextPerson

        public ImmutableSet<TextPerson> asTextPersonSet() {
            ImmutableSet.Builder<TextPerson> builder = ImmutableSet.builder();

            for (PersonCreator creator : creators) {
                builder.add(creator.asTextPerson());
            }
            return builder.build();
        }

        public Set<TextPerson> asTextPersonMutableSet() {
            Set<TextPerson> result = new HashSet<TextPerson>();

            for (PersonCreator creator : creators) {
                result.add(creator.asTextPerson());
            }
            return result;
        }

        // State

        public Set<PersonState> asStateSet() {
            Set<PersonState> result = new HashSet<PersonState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asState());
            }
            return result;
        }

        public Set<PersonMutableState> asMutableStateSet() {
            Set<PersonMutableState> result = new HashSet<PersonMutableState>();

            for (PersonCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }
    }

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

    public static class PersonMapBuilder {
        private final PersonMapEntryBuilder[] entries;

        public PersonMapBuilder(PersonMapEntryBuilder... entries) {
            this.entries = entries;
        }

        public ImmutableMap asPersonMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asPerson());
            }
            return builder.build();
        }

        public Map asPersonMutableMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asPerson());
            }
            return result;
        }

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (PersonMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (PersonMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

interface PersonMaker {
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
    Person asPerson();
    TextPerson asTextPerson();
    PersonState asState();
    PersonMutableState asMutableState();
}
