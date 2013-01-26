package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class CarSetEncapsulator implements Iterable<CarEncapsulator> {
    public CarStateSetBuilder stateSetBuilder = new CarStateSetBuilder();
    private List<CarEncapsulator> encapsulators = new ArrayList<CarEncapsulator>();

    public void add(CarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public CarSetEncapsulator(CarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (CarEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<CarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CarSet asCarSet() {
        List<Car> result = new ArrayList<Car>();

        for (CarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCar());
        }
        return new CarHashSet(result);
    }

    public boolean isValid() {
        for (CarEncapsulator encapsulator : encapsulators) {
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
