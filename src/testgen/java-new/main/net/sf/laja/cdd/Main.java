package net.sf.laja.cdd;

import static net.sf.laja.cdd.AddressIntegrator.createAddress;
import static net.sf.laja.cdd.PersonIntegrator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonStringState;

public class Main {
    public static void main(String[] args) {
        AddressIntegrator address = createAddress().streetName("gatan").withCity("Uppsala");

        Person person = createPerson()
                .name("Kalle")
                .birthday(1987,10,20)
                .children()
                .address(address).asPerson();

        PersonStringState personState = createPerson().name("Nils").birthday(1977,7,7).children().defaultAddress().getStringState();

        System.out.println(personState);
    }
}
