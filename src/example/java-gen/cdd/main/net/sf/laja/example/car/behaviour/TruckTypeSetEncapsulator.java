package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeSetEncapsulator implements Iterable<TruckTypeEncapsulator> {
    public TruckTypeStateSetBuilder stateSetBuilder = new TruckTypeStateSetBuilder();
    private List<TruckTypeEncapsulator> encapsulators = new ArrayList<TruckTypeEncapsulator>();

    public void add(TruckTypeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TruckTypeSetEncapsulator(TruckTypeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TruckTypeEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TruckTypeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TruckTypeSet asTruckTypeSet() {
        List<TruckType> result = new ArrayList<TruckType>();

        for (TruckTypeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTruckType());
        }
        return new TruckTypeHashSet(result);
    }

    public boolean isValid() {
        for (TruckTypeEncapsulator encapsulator : encapsulators) {
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
