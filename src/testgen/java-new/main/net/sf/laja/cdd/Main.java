package net.sf.laja.cdd;

import org.joda.time.DateMidnight;

import static net.sf.laja.cdd.AddressIntegrator.createAddress;
import static net.sf.laja.cdd.PersonIntegrator.createPerson;

public class Main {
    public static void main(String[] args) {
        AddressIntegrator address = createAddress().streetName("gatan").withCity("Uppsala");

        Person person = createPerson()
                .name("Kalle")
                .birthday(new DateMidnight(1987, 10, 20))
                .children()
                .address(address)
                .address2(address).asPerson();

        System.out.println(person);
    }
}
