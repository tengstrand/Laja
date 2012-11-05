package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;

public class CustomerList extends CustomerArrayList {
    public CustomerList(Customer... list) {
        super(list);
    }

    public CustomerList(List<Customer> list) {
        super(list);
    }
}
