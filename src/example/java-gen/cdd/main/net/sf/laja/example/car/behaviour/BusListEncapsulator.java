package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;

public class BusListEncapsulator implements Iterable<BusEncapsulator> {
    public BusStateListBuilder stateListBuilder = new BusStateListBuilder();
    private List<BusEncapsulator> encapsulators = new ArrayList<BusEncapsulator>();

    public void add(BusEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public BusListEncapsulator(BusEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BusEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<BusEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BusList asBusList() {
        List<Bus> result = new ArrayList<Bus>();

        for (BusEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBus());
        }
        return new BusArrayList(result);
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
        return stateListBuilder.toString();
    }
}
