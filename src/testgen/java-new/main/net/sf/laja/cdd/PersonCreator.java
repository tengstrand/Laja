package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonStringState;

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
        return new PersonBuilder();
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

    public PersonStringState getStringState() {
        return state.asStringState();
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
                public Address children() {
                    state.children = new ArrayList<PersonMutableState>();
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
        private PersonMutableState state = new PersonMutableState();

        public PersonBuilder withName(String name) {
            state.name = name;
            return this;
        }

        public PersonBuilder withBirthday(DateMidnight birthday) {
            state.birthday = birthday;
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

        public Person asPerson() {
            return new Person(state.asImmutable());
        }

        public PersonState getState() {
            return state.asImmutable();
        }

        public PersonMutableState getMutableState() {
            return state;
        }

        public PersonStringState getStringState() {
            return state.asStringState();
        }
    }
}
