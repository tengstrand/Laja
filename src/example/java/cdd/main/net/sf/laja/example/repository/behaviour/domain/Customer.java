package net.sf.laja.example.repository.behaviour.domain;

import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;

public class Customer extends CustomerFactory {
    private final Address address;

    public Customer(CustomerState state) {
        super(state);
        address = new Address(state.getAddress());
    }

    // (factory) (list)
    public Customer asCustomer() {
        return new Customer(state);
    }

    // (factory)
    public CustomerMatcher asCustomerMatcher() {
        return new CustomerMatcher(state);
    }

    public CustomerInDb asCustomerInDb() {
        return new CustomerInDb(state);
    }

    public CustomerInGui asCustomerInGui() {
        return new CustomerInGui(state);
    }
}
