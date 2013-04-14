package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;
import net.sf.laja.cdd.state.PersonMutableState;

public abstract class PersonFactory {

    public static Factory.Name age(int age) {
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

            public PersonIntegrator address(AddressMutableState address) {
                person.address = address;
                return new PersonIntegrator(person);
            }

            public PersonIntegrator address(AddressIntegrator encapsulator) {
                person.address = encapsulator.asMutableState();
                return new PersonIntegrator(person);
            }
        }
    }
}

