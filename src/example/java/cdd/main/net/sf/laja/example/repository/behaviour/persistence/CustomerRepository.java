package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.behaviour.domain.Address;
import net.sf.laja.example.repository.behaviour.domain.Customer;
import net.sf.laja.example.repository.behaviour.domain.CustomerEncapsulator;
import net.sf.laja.example.repository.behaviour.domain.CustomerListEncapsulator;
import net.sf.laja.example.repository.behaviour.domain.Zipcode;

public class CustomerRepository {
    CustomerListEncapsulator customers = Customer.createList(
            Customer.ssn(197501011234L).givenName("Eva").age(10).address(Address.streetName("Storgatan 1").zipcode(Zipcode.zipcode(12345)).city("Uppsala")).withSurname("Andersson"),
            Customer.ssn(198002036677L).givenName("Kalle").age(15).address(Address.streetName("Lillagatan 2").zipcode(Zipcode.zipcode(22233)).city("Stockholm")).withSurname("Karlsson"),
            Customer.ssn(19950405067788L).givenName("Sven").age(20).address(Address.streetName("Lillgatan 99").zipcode(Zipcode.zipcode(22244)).city("Gothenburg")).withSurname("Karlsson")
    );

    public CustomerListEncapsulator findBySurname(String surname) {
        CustomerListEncapsulator result = Customer.createList();

        for (CustomerEncapsulator encapsulator : customers) {
            if (encapsulator.asCustomerMatcher().hasMatchingSurname(surname)) {
                result.add(encapsulator);
            }
        }
        return result;
    }
}
