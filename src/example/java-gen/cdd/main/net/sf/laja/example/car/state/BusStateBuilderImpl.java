package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.VehicleSizeBehaviourFactory;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;
import net.sf.laja.example.car.state.VehicleSizeStateBuilderImpl;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
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

    public VehicleSizeStateBuilder getSizeStateBuilder() {
        return new VehicleSizeStateBuilderImpl(state.getSizeState());
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

    public Object as(BusBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public BusState getBusState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BusStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
