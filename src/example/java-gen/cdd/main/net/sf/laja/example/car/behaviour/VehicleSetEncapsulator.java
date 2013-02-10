package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleState;

public class VehicleSetEncapsulator implements Iterable<VehicleEncapsulator> {
    public VehicleStateSetBuilder stateSetBuilder = new VehicleStateSetBuilder();
    private List<VehicleEncapsulator> encapsulators = new ArrayList<VehicleEncapsulator>();

    public void add(VehicleEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public VehicleSetEncapsulator(VehicleEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (VehicleEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<VehicleEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public VehicleSet asVehicleSet() {
        List<Vehicle> result = new ArrayList<Vehicle>();

        for (VehicleEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asVehicle());
        }
        return new VehicleHashSet(result);
    }

    public boolean isValid() {
        for (VehicleEncapsulator encapsulator : encapsulators) {
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
