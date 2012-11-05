package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.behaviour.CarColor;

public class CarListCreator implements Iterable<CarEncapsulator> {
    public CarStateListBuilder stateList = new CarStateListBuilder();
    private List<CarEncapsulator> encapsulators = new ArrayList<CarEncapsulator>();

    public void add(CarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public CarListCreator(CarEncapsulator... encapsulators) {
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
