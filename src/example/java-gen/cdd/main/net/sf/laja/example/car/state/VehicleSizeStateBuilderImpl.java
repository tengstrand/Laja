package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class VehicleSizeStateBuilderImpl implements VehicleSizeStateBuilder {
    private Object encapsulator;
    private VehicleSizeState state;
    private final Certificate certificate;

    VehicleSizeStateBuilderImpl() {
        state = new VehicleSizeStateImpl();
        certificate = Certificate.get(this);
    }

    public VehicleSizeStateBuilderImpl(VehicleSizeState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public VehicleSizeStateBuilderImpl(VehicleSizeState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withLengthInCentimeters(int lengthInCentimeters) {
        state.setLengthInCentimeters(lengthInCentimeters, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(VehicleSizeStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public VehicleSizeState getVehicleSizeState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
