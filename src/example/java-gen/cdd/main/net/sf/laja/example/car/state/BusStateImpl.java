package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class BusStateImpl implements BusState {
    protected String name;
    protected int lengthInCentimeters;
    protected int weightInKilograms; // (optional)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    public VehicleSizeState getSizeState() {
        return new VehicleSizeState() {
            public Certificate certificate() { return certificate(); }
            public int getLengthInCentimeters() { return 0; /* missing attribute 'lengthInCentimeters' */ }
            public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { /* missing attribute 'lengthInCentimeters' */ }

            public void encapsulate() { BusStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { BusStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
        if (!isVehicleSizeValid()) {
            return false;
        }
                return lengthInCentimeters >= 0;
            }

    private boolean isVehicleSizeValid() {
        return lengthInCentimeters >= 0;
    }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof BusStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                net.sf.laja.example.car.state.VehicleSizeState state = (net.sf.laja.example.car.state.VehicleSizeState)value;

                if (lengthInCentimeters != state.getLengthInCentimeters()) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = lengthInCentimeters;

                return result;
            }

            @Override
            public String toString() {
                return "{lengthInCentimeters=" + getLengthInCentimeters() + "}";
            }
        };
    }

    BusStateImpl() {
    }

    public BusStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static BusStateBuilder build() {
        return new BusStateBuilderImpl();
    }

    public static BusStateBuilder build(BusState state) {
        return new BusStateBuilderImpl(state);
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
        if (name == null) {
            return false;
        }
        if (!isVehicleSizeValid()) {
            return false;
        }
        return true;
    }

    private boolean isVehicleSizeValid() {
        return lengthInCentimeters >= 0;
    }

    // Getters
    public String getName() { return name; }
    public int getLengthInCentimeters() { return lengthInCentimeters; }
    public int getWeightInKilograms() { return weightInKilograms; }

    // Setters
    public void setName(String name, Object mutator) { checkMutator(mutator); this.name = name; }
    public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { checkMutator(mutator); this.lengthInCentimeters = lengthInCentimeters; }
    public void setWeightInKilograms(int weightInKilograms, Object mutator) { checkMutator(mutator); this.weightInKilograms = weightInKilograms; }

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
       if (!(that instanceof BusStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        BusStateImpl state = (BusStateImpl)value;

        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + lengthInCentimeters;
        result = 31 * result + weightInKilograms;

        return result;
    }

    @Override
    public String toString() {
        return "{name=" + (name == null ? null : '\'' + name + '\'' ) +
                ", lengthInCentimeters=" + lengthInCentimeters +
                ", weightInKilograms=" + weightInKilograms + "}";
    }
}
