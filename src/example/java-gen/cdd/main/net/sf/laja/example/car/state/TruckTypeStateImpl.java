package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckTypeStateImpl implements TruckTypeState {
    protected int numberOfWheels;
    protected String truckName;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    TruckTypeStateImpl() {
    }

    public TruckTypeStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static TruckTypeStateBuilder build() {
        return new TruckTypeStateBuilderImpl();
    }

    public static TruckTypeStateBuilder build(TruckTypeState state) {
        return new TruckTypeStateBuilderImpl(state);
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        return isValid(_encapsulated);
    }

    public boolean isValidAsEncapsulated() {
        return isValid(true);
    }

    private boolean isValid(boolean encapsulated) {
        if (truckName == null) {
            return false;
        }
        return true;
    }

    // Getters
    public int getNumberOfWheels() { return numberOfWheels; }
    public String getTruckName() { return truckName; }

    // Setters
    public void setNumberOfWheels(int numberOfWheels, Object mutator) { checkMutator(mutator); this.numberOfWheels = numberOfWheels; }
    public void setTruckName(String truckName, Object mutator) { checkMutator(mutator); this.truckName = truckName; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by current instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
        }
    }

    public void encapsulate() {
        _encapsulated = true;
    }

    public void setEncapsulator(Object encapsulator) {
        _encapsulator = encapsulator;
    }

    @Override
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof TruckTypeStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        TruckTypeStateImpl state = (TruckTypeStateImpl)value;

        if (numberOfWheels != state.getNumberOfWheels()) return false;
        if (truckName != null ? !truckName.equals(state.getTruckName()) : state.getTruckName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfWheels;
        result = 31 * result + (truckName != null ? truckName.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{numberOfWheels=" + numberOfWheels +
                ", truckName='" + truckName + '\'' + "}";
    }
}
