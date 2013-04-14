package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressStateBuilder;
import net.sf.laja.cdd.state.PersonState;

public class Main2 {
    public static void main(String[] args) {
        Person person = Person.age(10).name("Kalle").address(AddressFactory.streetName("gatan").withCity("Uppsala")).asPerson();

        PersonText personText = new PersonText(person.state);

        PersonState state = person.state.asMutable().setAge(10).asImmutable();
        System.out.println("hashCode()=" + state);
        System.out.println("super.hashCode()=" + state.superHashCode());

        PersonMutable personMutable = Person.age(1).name("").address().asPersonMutable();

        //new AddressStateBuilder().withId(1).
    }
}

