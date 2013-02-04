package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckTypeStateBuilderImpl implements TruckTypeStateBuilder {
    private Object encapsulator;
    private TruckTypeState state;
    private final Certificate certificate;

    TruckTypeStateBuilderImpl() {
        state = new TruckTypeStateImpl();
        certificate = Certificate.get(this);
    }

    public TruckTypeStateBuilderImpl(TruckTypeState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public TruckTypeStateBuilderImpl(TruckTypeState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withNumberOfWheels(int numberOfWheels) {
        state.setNumberOfWheels(numberOfWheels, encapsulator);
    }

    public void withTruckName(String truckName) {
        state.setTruckName(truckName, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(TruckTypeBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public TruckTypeState getTruckTypeState(net.sf.laja.example.car.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TruckTypeStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
