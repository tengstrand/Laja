package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.TruckState;
import net.sf.laja.example.car.behaviour.CarColor;

public class TruckListEncapsulator implements Iterable<TruckEncapsulator> {
    public TruckStateListBuilder stateList = new TruckStateListBuilder();
    private List<TruckEncapsulator> encapsulators = new ArrayList<TruckEncapsulator>();

    public void add(TruckEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TruckListEncapsulator(TruckEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TruckEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<TruckEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TruckList asTruckList() {
        List<Truck> result = new ArrayList<Truck>();

        for (TruckEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTruck());
        }
        return new TruckArrayList(result);
    }

    public boolean isValid() {
        for (TruckEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
