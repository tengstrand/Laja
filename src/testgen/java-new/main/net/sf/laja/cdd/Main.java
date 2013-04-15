package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

import static net.sf.laja.cdd.AddressIntegrator.AddressFactory.streetName;
import static net.sf.laja.cdd.PersonIntegrator.PersonFactory.createPerson;

public class Main {
    public static void main(String[] args) {
        Person person = createPerson().age(10).name("Kalle").address(streetName("gatan").withCity("Uppsala")).asPerson();

        PersonText personText = new PersonText(person.state);

        PersonState state = person.state.asMutable().setAge(10).asImmutable();
        System.out.println("hashCode()=" + state);
        System.out.println("super.hashCode()=" + state.superHashCode());

        SpecialPerson personMutable = createPerson().age(1).name("").address().asSpecialPerson();

        //new AddressStateBuilder().withId(1).
    }
}
