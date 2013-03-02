package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;
// Zipcode

public class CustomerEncapsulator implements CustomerStateComparable {
    public final CustomerStateBuilder builder;

    public CustomerEncapsulator(CustomerStateBuilder builder) {
        this.builder = builder;
    }

    public Customer asCustomer() {
        return (Customer)builder.as(new CustomerFactory.CustomerFactory_(builder));
    }

    public CustomerMatcher asCustomerMatcher() {
        return (CustomerMatcher)builder.as(new CustomerFactory.CustomerMatcherFactory_(builder));
    }

    public CustomerEncapsulator withSurname(String surname) {
        builder.withSurname(surname);
        return this;
    }

    public CustomerEncapsulator withPet(String pet) {
        builder.withPet(pet);
        return this;
    }

    public CustomerEncapsulator withOldAddresses(AddressEncapsulator... oldAddresses) {
        AddressListEncapsulator encapsulator = new AddressListEncapsulator(oldAddresses);
        builder.withOldAddresses(encapsulator.stateListBuilder);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
