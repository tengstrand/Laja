package net.sf.laja.example.car.behaviour;

import java.util.*;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.VehicleState;

public class VehicleListEncapsulator implements Iterable<VehicleEncapsulator> {
    public VehicleStateListBuilder stateListBuilder = new VehicleStateListBuilder();
    private List<VehicleEncapsulator> encapsulators = new ArrayList<VehicleEncapsulator>();

    public void add(VehicleEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public VehicleListEncapsulator(VehicleEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (VehicleEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<VehicleEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public VehicleList asVehicleList() {
        List<Vehicle> result = new ArrayList<Vehicle>();

        for (VehicleEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asVehicle());
        }
        return new VehicleArrayList(result);
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
        return stateListBuilder.toString();
    }
}
