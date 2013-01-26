package net.sf.laja.example.repository.behaviour.domain;

import java.util.*;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;

public class AddressSetEncapsulator implements Iterable<AddressEncapsulator> {
    public AddressStateSetBuilder stateSetBuilder = new AddressStateSetBuilder();
    private List<AddressEncapsulator> encapsulators = new ArrayList<AddressEncapsulator>();

    public void add(AddressEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public AddressSetEncapsulator(AddressEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (AddressEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<AddressEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public AddressSet asAddressSet() {
        List<Address> result = new ArrayList<Address>();

        for (AddressEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asAddress());
        }
        return new AddressHashSet(result);
    }

    public boolean isValid() {
        for (AddressEncapsulator encapsulator : encapsulators) {
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
