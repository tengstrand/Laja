package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusSetEncapsulator implements Iterable<BusEncapsulator> {
    public BusStateSetBuilder stateSetBuilder = new BusStateSetBuilder();
    private List<BusEncapsulator> encapsulators = new ArrayList<BusEncapsulator>();

    public void add(BusEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public BusSetEncapsulator(BusEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BusEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<BusEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BusSet asBusSet() {
        List<Bus> result = new ArrayList<Bus>();

        for (BusEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBus());
        }
        return new BusHashSet(result);
    }

    public boolean isValid() {
        for (BusEncapsulator encapsulator : encapsulators) {
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
