package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherList;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherArrayList;

public class CustomerListCreator implements Iterable<CustomerEncapsulator> {
    public CustomerStateListBuilder stateList = new CustomerStateListBuilder();
    private List<CustomerEncapsulator> encapsulators = new ArrayList<CustomerEncapsulator>();

    public void add(CustomerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public CustomerListCreator(CustomerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (CustomerEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<CustomerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CustomerList asCustomerList() {
        List<Customer> result = new ArrayList<Customer>();

        for (CustomerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCustomer());
        }
        return new CustomerArrayList(result);
    }

    public CustomerMatcherList asCustomerMatcherList() {
        List<CustomerMatcher> result = new ArrayList<CustomerMatcher>();

        for (CustomerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCustomerMatcher());
        }
        return new CustomerMatcherArrayList(result);
    }

    public boolean isValid() {
        for (CustomerEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
