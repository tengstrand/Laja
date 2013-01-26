package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherHashSet;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherList;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherArrayList;

public class CustomerSetEncapsulator implements Iterable<CustomerEncapsulator> {
    public CustomerStateSetBuilder stateSetBuilder = new CustomerStateSetBuilder();
    private List<CustomerEncapsulator> encapsulators = new ArrayList<CustomerEncapsulator>();

    public void add(CustomerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public CustomerSetEncapsulator(CustomerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (CustomerEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<CustomerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CustomerSet asCustomerSet() {
        List<Customer> result = new ArrayList<Customer>();

        for (CustomerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCustomer());
        }
        return new CustomerHashSet(result);
    }

    public CustomerMatcherSet asCustomerMatcherSet() {
        List<CustomerMatcher> result = new ArrayList<CustomerMatcher>();

        for (CustomerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCustomerMatcher());
        }
        return new CustomerMatcherHashSet(result);
    }

    public boolean isValid() {
        for (CustomerEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateSetBuilder.toString();
    }
}
