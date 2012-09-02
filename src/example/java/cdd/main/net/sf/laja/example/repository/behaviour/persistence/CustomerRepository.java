package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.behaviour.domain.Customer;
import net.sf.laja.example.repository.behaviour.domain.CustomerEncapsulator;
import net.sf.laja.example.repository.behaviour.domain.CustomerListCreator;

public class CustomerRepository {
    CustomerListCreator customers = Customer.createList(
            Customer.ssn(197501011234L).givenName("Eva").age(10).streetName("Storgatan 1").zipcode(12345).city("Uppsala").withSurname("Andersson"),
            Customer.ssn(198002036677L).givenName("Kalle").age(15).streetName("Lillagatan 2").zipcode(22233).city("Stockholm").withSurname("Karlsson"),
            Customer.ssn(19950405067788L).givenName("Sven").age(20).streetName("Lillgatan 99").zipcode(22244).city("Gothenburg").withSurname("Karlsson")
    );

    public CustomerListCreator findBySurname(String surname) {
        CustomerListCreator result = Customer.createList();

        for (CustomerEncapsulator encapsulator : customers) {
            if (encapsulator.asCustomerMatcher().hasMatchingSurname(surname)) {
                result.add(encapsulator);
            }
        }
        return result;
    }
}
