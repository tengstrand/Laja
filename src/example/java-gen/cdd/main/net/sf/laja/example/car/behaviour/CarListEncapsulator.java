package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.CarStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarListEncapsulator implements Iterable<CarEncapsulator> {
    public CarStateListBuilder stateList = new CarStateListBuilder();
    private List<CarEncapsulator> encapsulators = new ArrayList<CarEncapsulator>();

    public void add(CarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public CarListEncapsulator(CarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (CarEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<CarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public CarList asCarList() {
        List<Car> result = new ArrayList<Car>();

        for (CarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asCar());
        }
        return new CarArrayList(result);
    }

    public boolean isValid() {
        for (CarEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
