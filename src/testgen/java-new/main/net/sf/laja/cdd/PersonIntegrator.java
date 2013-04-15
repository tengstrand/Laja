package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;
import net.sf.laja.cdd.state.PersonState;

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

    public PersonIntegrator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState getState() {
        return state.asImmutable();
    }

    public PersonMutableState getMutableState() {
        return state;
    }

    public PersonIntegrator withAddress(AddressState.AddressMutableState address) {
        state.address = address;
        return this;
    }

    public static class PersonFactory {

        public static PersonFactory createPerson() {
            return new PersonFactory();
        }

        public Factory.Name age(int age) {
            return new Factory().new Age().age(age);
        }

        private static class Factory {
            private final PersonMutableState person = new PersonMutableState();

            public class Age {
                public Name age(int age) {
                    person.age = age;
                    return new Name();
                }
            }

            public class Name {
                public Address name(String name) {
                    person.name = name;
                    return new Address();
                }
            }

            public class Address {
                public PersonIntegrator address() {
                    person.address = null;
                    return new PersonIntegrator(person);
                }

                public PersonIntegrator address(AddressState.AddressMutableState address) {
                    person.address = address;
                    return new PersonIntegrator(person);
                }

                public PersonIntegrator address(AddressIntegrator integrator) {
                    person.address = integrator.getMutableState();
                    return new PersonIntegrator(person);
                }
            }
        }
    }
}
