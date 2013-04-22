package net.sf.laja.cdd;

import static net.sf.laja.cdd.AddressCreator.createAddress;
import static net.sf.laja.cdd.PersonCreator.createPerson;

public class Main {
    public static void main(String[] args) {
        AddressCreator address = createAddress().streetName("gatan").withCity("Uppsala");

        Person person = createPerson()
                .name("Kalle")
                .birthday(1987, 10, 20)
                .children(createPerson().name("").birthday(2010, 1, 1).children().defaultAddress())
                .address(address).asPerson();

        System.out.println(person.state.asMutable());
    }
}
