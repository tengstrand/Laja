package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class TestCarListEncapsulator implements Iterable<TestCarEncapsulator> {
    public CarStateListBuilder stateListBuilder = new CarStateListBuilder();
    private List<TestCarEncapsulator> encapsulators = new ArrayList<TestCarEncapsulator>();

    public void add(TestCarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TestCarListEncapsulator(TestCarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestCarEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestCarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CarList asCarList(VehicleSize size) {
        List<Car> result = new ArrayList<Car>();

        for (TestCarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCar(size));
        }
        return new CarArrayList(result);
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
        return stateListBuilder.toString();
    }
}
