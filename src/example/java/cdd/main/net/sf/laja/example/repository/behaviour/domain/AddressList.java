package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;

public class AddressList extends AddressAbstractList {
    public AddressList(Address... list) {
        super(list);
    }

    public AddressList(List<Address> list) {
        super(list);
    }
}
