package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerListEncapsulator implements Iterable<OwnerEncapsulator> {
    public OwnerStateListBuilder stateList = new OwnerStateListBuilder();
    private List<OwnerEncapsulator> encapsulators = new ArrayList<OwnerEncapsulator>();

    public void add(OwnerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public OwnerListEncapsulator(OwnerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (OwnerEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<OwnerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public OwnerList asOwnerList() {
        List<Owner> result = new ArrayList<Owner>();

        for (OwnerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asOwner());
        }
        return new OwnerArrayList(result);
    }

    public boolean isValid() {
        for (OwnerEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
