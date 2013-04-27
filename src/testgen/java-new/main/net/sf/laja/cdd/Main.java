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

        PersonCreator.createPersonList(PersonCreator.createPerson().name("").birthday(2010, 1, 2).children().defaultAddress()).asArrayList();

        DbPerson dbPerson = createPerson().name("Carl").birthday(1971,2,3).children().defaultAddress().asDbPerson();
        String sqlStatement = dbPerson.getInsertStatement();
        System.out.println(sqlStatement);
    }
}
