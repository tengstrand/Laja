package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class VehicleSizeStateImpl implements VehicleSizeState {
    protected int lengthInCentimeters;

    private boolean _encapsulated = false;

    VehicleSizeStateImpl() {
    }

    public static VehicleSizeStateBuilder build() {
        return new VehicleSizeStateBuilderImpl();
    }

    public static VehicleSizeStateBuilder build(VehicleSizeState state) {
        return new VehicleSizeStateBuilderImpl(state);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        return lengthInCentimeters >= 0;
    }

    // Getters
    public int getLengthInCentimeters() { return lengthInCentimeters; }

    // Setters
    public void setLengthInCentimeters(int lengthInCentimeters) { this.lengthInCentimeters = lengthInCentimeters; }

    public void encapsulate() {
        _encapsulated = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleSizeStateImpl state = (VehicleSizeStateImpl)o;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleSizeStateImpl state = (VehicleSizeStateImpl)o;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lengthInCentimeters;

        return result;
    }

    public int valueHashCode() {
        int result = lengthInCentimeters;

        return result;
    }

    @Override
    public String toString() {
        return "{lengthInCentimeters=" + lengthInCentimeters + "}";
    }
}
