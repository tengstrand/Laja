package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeListEncapsulator implements Iterable<VehicleSizeEncapsulator> {
    public VehicleSizeStateListBuilder stateList = new VehicleSizeStateListBuilder();
    private List<VehicleSizeEncapsulator> encapsulators = new ArrayList<VehicleSizeEncapsulator>();

    public void add(VehicleSizeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public VehicleSizeListEncapsulator(VehicleSizeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<VehicleSizeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public VehicleSizeList asVehicleSizeList() {
        List<VehicleSize> result = new ArrayList<VehicleSize>();

        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asVehicleSize());
        }
        return new VehicleSizeArrayList(result);
    }

    public boolean isValid() {
        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
