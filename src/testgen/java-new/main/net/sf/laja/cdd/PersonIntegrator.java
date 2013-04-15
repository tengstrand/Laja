package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;

import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

public class PersonIntegrator {
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

    public PersonIntegrator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState getState() {
        return state.asImmutable();
    }

    public PersonMutableState getMutableState() {
        return state;
    }

    public PersonIntegrator withAddress(AddressMutableState address) {
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
                public PersonIntegrator address() {
                    state.address = null;
                    return new PersonIntegrator(state);
                }

                public Address2 address(AddressMutableState address) {
                    state.address = address;
                    return new Address2();
                }

                public Address2 address(AddressIntegrator integrator) {
                    state.address = integrator.getMutableState();
                    return new Address2();
                }
            }

            public class Address2 {
                public PersonIntegrator address2() {
                    state.address2 = null;
                    return new PersonIntegrator(state);
                }

                public PersonIntegrator address2(AddressMutableState address2) {
                    state.address2 = address2;
                    return new PersonIntegrator(state);
                }

                public PersonIntegrator address2(AddressIntegrator integrator) {
                    state.address2 = integrator.getMutableState();
                    return new PersonIntegrator(state);
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

        public PersonBuilder withAddress2(AddressMutableState address2) {
            state.address2 = address2;
            return this;
        }

        public Person asPerson() {
            return new Person(state.asImmutable());
        }
    }
}
