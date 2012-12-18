package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.VehicleSizeStateBehaviourFactory;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BusStateBuilderImpl implements BusStateBuilder {
    private Object encapsulator;
    private BusState state;
    private final Certificate certificate;

    BusStateBuilderImpl() {
        state = new BusStateImpl();
        certificate = Certificate.get(this);
    }

    public BusStateBuilderImpl(BusState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public BusStateBuilderImpl(BusState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withName(String name) {
        state.setName(name, encapsulator);
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        state.setLengthInCentimeters(lengthInCentimeters, encapsulator);
    }

    public void withWeightInKilograms(int weightInKilograms) {
        state.setWeightInKilograms(weightInKilograms, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(BusStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(VehicleSizeStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public BusState getBusState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    public VehicleSizeState getVehicleSizeState(Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
