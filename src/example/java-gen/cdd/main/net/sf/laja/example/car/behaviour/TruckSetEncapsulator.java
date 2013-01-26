package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;

public class TruckSetEncapsulator implements Iterable<TruckEncapsulator> {
    public TruckStateSetBuilder stateSetBuilder = new TruckStateSetBuilder();
    private List<TruckEncapsulator> encapsulators = new ArrayList<TruckEncapsulator>();

    public void add(TruckEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TruckSetEncapsulator(TruckEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TruckEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TruckEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TruckSet asTruckSet() {
        List<Truck> result = new ArrayList<Truck>();

        for (TruckEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTruck());
        }
        return new TruckHashSet(result);
    }

    public boolean isValid() {
        for (TruckEncapsulator encapsulator : encapsulators) {
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
