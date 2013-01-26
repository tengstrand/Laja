package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleSizeState;

public class VehicleSizeSetEncapsulator implements Iterable<VehicleSizeEncapsulator> {
    public VehicleSizeStateSetBuilder stateSetBuilder = new VehicleSizeStateSetBuilder();
    private List<VehicleSizeEncapsulator> encapsulators = new ArrayList<VehicleSizeEncapsulator>();

    public void add(VehicleSizeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public VehicleSizeSetEncapsulator(VehicleSizeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<VehicleSizeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public VehicleSizeSet asVehicleSizeSet() {
        List<VehicleSize> result = new ArrayList<VehicleSize>();

        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asVehicleSize());
        }
        return new VehicleSizeHashSet(result);
    }

    public boolean isValid() {
        for (VehicleSizeEncapsulator encapsulator : encapsulators) {
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
