package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

import java.util.Map;

import static net.sf.laja.cdd.AddressCreator.createAddress;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

public class Main {
    public static void main(String[] args) {
        AddressCreator address = createAddress().streetName("gatan").withCity("Uppsala");

        Person person = createPerson()
                .name("Kalle")
                .birthday(1987, 10, 20)
                .children(createPerson().name("").birthday(2010, 1, 1).children().defaultAddress())
                .address(address).asPerson();

        Map object = person.state.asData();

        PersonMutableState mutableState = PersonState.converter.asMutableState(object);

        System.out.println(object);
        System.out.println(person.state.asMutable());
        System.out.println(mutableState);
    }
}
