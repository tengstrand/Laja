package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class TestCarSetEncapsulator implements Iterable<TestCarEncapsulator> {
    public CarStateSetBuilder stateSetBuilder = new CarStateSetBuilder();
    private List<TestCarEncapsulator> encapsulators = new ArrayList<TestCarEncapsulator>();

    public void add(TestCarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestCarSetEncapsulator(TestCarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestCarEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestCarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CarSet asCarSet(VehicleSize size) {
        List<Car> result = new ArrayList<Car>();

        for (TestCarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCar(size));
        }
        return new CarHashSet(result);
    }

    public boolean isValid() {
        for (TestCarEncapsulator encapsulator : encapsulators) {
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
