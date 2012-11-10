package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;

import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherList;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcherArrayList;

public interface CustomerList extends List<Customer> {
    CustomerMatcherList asCustomerMatcherList();
}
