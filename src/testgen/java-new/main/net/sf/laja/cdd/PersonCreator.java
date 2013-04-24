package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.AddressCreator.buildAddress;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

public class PersonCreator {
    private final PersonMutableState state;

    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    public SpecialPerson asSpecialPerson() {
        return new SpecialPerson(state);
    }

    // Generated code goes here...

    public static PersonFactory createPerson() {
        return new PersonFactory();
    }

    public static PersonBuilder buildPerson() {
        return PersonBuilder.create();
    }

    public static PersonListBuilder personList(PersonBuilder... builders) {
        return new PersonListBuilder(builders);
    }

    public static PersonSetBuilder personSet(PersonBuilder... builders) {
        return new PersonSetBuilder(builders);
    }

    public PersonCreator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState getState() {
        return state.asImmutable();
    }

    public PersonMutableState getMutableState() {
        return state;
    }

    public PersonCreator withAddress(AddressMutableState address) {
        state.address = address;
        return this;
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
                // TODO: Add support for the (y,m,d) format.
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
                        children.add(creator.getMutableState());
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
                // TODO: Make sure this row is preserved when generated.
                public PersonCreator defaultAddress() {
                    state.address = buildAddress().getMutableState();
                    return new PersonCreator(state);
                }

                public PersonCreator address(AddressMutableState address) {
                    state.address = address;
                    return new PersonCreator(state);
                }

                public PersonCreator address(AddressCreator integrator) {
                    state.address = integrator.getMutableState();
                    return new PersonCreator(state);
                }
            }
        }
    }

    public static class PersonBuilder {
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
            state.address = address.getMutableState();
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

        public SpecialPerson asSpecialPerson() {
            return new SpecialPerson(state);
        }

        public PersonState getState() {
            return state.asImmutable();
        }

        public PersonMutableState getMutableState() {
            return state;
        }
    }

    public static class PersonListBuilder {
        private PersonBuilder[] builders;

        public PersonListBuilder(PersonBuilder... builders) {
            this.builders = builders;
        }

        public List<Person> asArrayList() {
            List<Person> result = new ArrayList<Person>();

            for (PersonBuilder builder : builders) {
                result.add(builder.asPerson());
            }
            return result;
        }

        public List<PersonState> asImmutableStateList() {
            return asImmutableStateArrayList();
        }

        public List<PersonState> asImmutableStateArrayList() {
            List<PersonState> result = new ArrayList<PersonState>();

            for (PersonBuilder builder : builders) {
                result.add(builder.getState());
            }
            return result;
        }

        public List<PersonMutableState> asMutableStateList() {
            return asMutableStateArrayList();
        }

        public List<PersonMutableState> asMutableStateArrayList() {
            List<PersonMutableState> result = new ArrayList<PersonMutableState>();

            for (PersonBuilder builder : builders) {
                result.add(builder.getMutableState());
            }
            return result;
        }
    }

    public static class PersonSetBuilder {
        private PersonBuilder[] builders;

        public PersonSetBuilder(PersonBuilder... builders) {
            this.builders = builders;
        }

        public Set<Person> asHashSet() {
            Set<Person> result = new HashSet<Person>();

            for (PersonBuilder builder : builders) {
                result.add(builder.asPerson());
            }
            return result;
        }

        public Set<PersonState> asImmutableStateSet() {
            return asImmutableStateHashSet();
        }

        public Set<PersonState> asImmutableStateHashSet() {
            Set<PersonState> result = new HashSet<PersonState>(builders.length);

            for (PersonBuilder builder : builders) {
                result.add(builder.getState());
            }
            return result;
        }

        public Set<PersonMutableState> asMutableStateSet() {
            return asMutableStateHashSet();
        }

        public Set<PersonMutableState> asMutableStateHashSet() {
            Set<PersonMutableState> result = new HashSet<PersonMutableState>();

            for (PersonBuilder builder : builders) {
                result.add(builder.getMutableState());
            }
            return result;
        }
    }
}
