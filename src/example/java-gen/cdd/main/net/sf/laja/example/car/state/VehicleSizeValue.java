package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class VehicleSizeValue implements VehicleSizeElement {
    protected final VehicleSizeState state;
    protected VehicleSizeStateBuilder stateBuilder;

    public VehicleSizeValue(VehicleSizeState state) {
        this.state = state;
    }

    public VehicleSizeValue(VehicleSizeState state, VehicleSizeStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public boolean contains(VehicleSizeStateList stateList) {
        return stateList.contains(state);
    }

    public VehicleSizeState getState(Certificate certificate) {
        return state;
    }

    public VehicleSizeState getState(VehicleSizeStateList stateList) {
        return state;
    }

    public void addToList(VehicleSizeStateList stateList) {
        stateList.add(state);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((VehicleSizeValue)o).state);
    }

    @Override
    public int hashCode() {
        return state.valueHashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + state;
    }
}
