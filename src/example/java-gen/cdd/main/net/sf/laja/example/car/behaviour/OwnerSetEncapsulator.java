package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerSetEncapsulator implements Iterable<OwnerEncapsulator> {
    public OwnerStateSetBuilder stateSetBuilder = new OwnerStateSetBuilder();
    private List<OwnerEncapsulator> encapsulators = new ArrayList<OwnerEncapsulator>();

    public void add(OwnerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public OwnerSetEncapsulator(OwnerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (OwnerEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<OwnerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public OwnerSet asOwnerSet() {
        List<Owner> result = new ArrayList<Owner>();

        for (OwnerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asOwner());
        }
        return new OwnerHashSet(result);
    }

    public boolean isValid() {
        for (OwnerEncapsulator encapsulator : encapsulators) {
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
