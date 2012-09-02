package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerBuilder {
    public final CustomerStateBuilder builder;

    public CustomerBuilder() {
        builder = CustomerStateImpl.build();
    }

    public CustomerBuilder(CustomerState state) {
        builder = CustomerStateImpl.build(state);
    }

    public CustomerBuilder withSsn(long ssn) {
        builder.withSsn(ssn);
        return this;
    }

    public CustomerBuilder withGivenName(String givenName) {
        builder.withGivenName(givenName);
        return this;
    }

    public CustomerBuilder withSurname(String surname) {
        builder.withSurname(surname);
        return this;
    }

    public CustomerBuilder withAge(int age) {
        builder.withAge(age);
        return this;
    }

    public CustomerBuilder withPet(String pet) {
        builder.withPet(pet);
        return this;
    }

    public CustomerBuilder withStreetName(String streetName) {
        builder.withStreetName(streetName);
        return this;
    }

    public CustomerBuilder withZipcode(int zipcode) {
        builder.withZipcode(zipcode);
        return this;
    }

    public CustomerBuilder withCity(String city) {
        builder.withCity(city);
        return this;
    }

    public CustomerBuilder withOldAddresses(AddressListCreator oldAddresses) {
        builder.withOldAddresses(oldAddresses.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Customer asCustomer() {
        return (Customer)builder.as(new CustomerFactory.CustomerFactory_(builder));
    }

    public CustomerMatcher asCustomerMatcher() {
        return (CustomerMatcher)builder.as(new CustomerFactory.CustomerMatcherFactory_(builder));
    }
}
