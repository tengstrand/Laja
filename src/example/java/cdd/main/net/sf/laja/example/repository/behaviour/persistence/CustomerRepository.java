package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.behaviour.domain.CustomerCreator;

import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.example.repository.behaviour.domain.AddressCreator.createAddress;
import static net.sf.laja.example.repository.behaviour.domain.CustomerCreator.*;
import static net.sf.laja.example.repository.behaviour.domain.ZipcodeCreator.createZipcode;

public class CustomerRepository {
    CustomerListBuilder customers = createCustomerList(
            createCustomer().ssn(197501011234L).givenName("Eva").age(10).address(createAddress().streetName("Storgatan 1").zipcode(createZipcode().zipcode(12345)).city("Uppsala")).withSurname("Andersson"),
            createCustomer().ssn(198002036677L).givenName("Kalle").age(15).address(createAddress().streetName("Lillgatan 1").zipcode(createZipcode().zipcode(22233)).city("Stockholm")).withSurname("Karlsson"),
            createCustomer().ssn(19950405067788L).givenName("Sven").age(15).address(createAddress().streetName("Lillgatan 99").zipcode(createZipcode().zipcode(22244)).city("Gothenburg")).withSurname("Karlsson"));

    public CustomerListBuilder findBySurname(String surname) {
        List<CustomerCreator> result = new ArrayList<CustomerCreator>();

        for (CustomerCreator creator : customers) {
            if (creator.asCustomerMatcher().hasMatchingSurname(surname)) {
                result.add(creator);
            }
        }
        return new CustomerListBuilder(result);
    }
}
