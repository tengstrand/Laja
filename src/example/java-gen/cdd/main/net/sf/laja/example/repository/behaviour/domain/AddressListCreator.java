package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;

public class AddressListCreator implements Iterable<AddressEncapsulator> {
    public AddressStateListBuilder stateList = new AddressStateListBuilder();
    private List<AddressEncapsulator> encapsulators = new ArrayList<AddressEncapsulator>();

    public void add(AddressEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public AddressListCreator(AddressEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AddressEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<AddressEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AddressList asAddressList() {
        List<Address> result = new ArrayList<Address>();

        for (AddressEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAddress());
        }
        return new AddressList(result);
    }

    public boolean isValid() {
        for (AddressEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
