package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeListEncapsulator implements Iterable<TruckTypeEncapsulator> {
    public TruckTypeStateListBuilder stateListBuilder = new TruckTypeStateListBuilder();
    private List<TruckTypeEncapsulator> encapsulators = new ArrayList<TruckTypeEncapsulator>();

    public void add(TruckTypeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TruckTypeListEncapsulator(TruckTypeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TruckTypeEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TruckTypeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TruckTypeList asTruckTypeList() {
        List<TruckType> result = new ArrayList<TruckType>();

        for (TruckTypeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTruckType());
        }
        return new TruckTypeArrayList(result);
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
        return stateListBuilder.toString();
    }
}
