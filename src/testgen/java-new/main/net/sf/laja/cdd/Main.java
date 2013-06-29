package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;

import static net.sf.laja.cdd.AddressCreator.createAddress;
import static net.sf.laja.cdd.AddressCreator.createAddressList;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.SpecialAddressCreator.createSpecialAddress;

public class Main {
    public static void main(String[] args) {

        ImmutableList<Address> addresses1 = createAddressList(createAddress()
            .withStreetName("First street").withCity("Uppsala").withId(1)).asAddressList(AddressType.PROTECTED);
        System.out.println(addresses1);

        ImmutableList<Address> addresses2 = ImmutableList.of(
                createAddress().asAddress(),
                createAddress().asAddress(AddressType.PROTECTED)
        );
        System.out.println(addresses2);

        Address address1 = createAddress().withStreetName("Second street").withCity("Stockholm").asAddress(5);
        Address address2 = createAddress().asAddress(10);
        System.out.println(address1);
        System.out.println(address2);

        Address specialAddress = createSpecialAddress().asSpecialAddress();
        System.out.println(specialAddress);

        // -------------

        PersonCreator.PersonFactory personFactory = createPerson();
        PersonCreator personCreator = personFactory.name("kalle").hairColor("RED").children().defaults();

        personCreator.isValid();
        personCreator.validate();
        personCreator.assertIsValid();

        personCreator.asPerson();
        personCreator.asTextPerson();
        personCreator.asSpecialPerson();
        personCreator.asState();
        personCreator.asMutableState();
    }
}
