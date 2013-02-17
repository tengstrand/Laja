package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.TruckTypeState;
import net.sf.laja.example.car.state.OwnerState;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateImpl;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateImpl;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TruckStateImpl implements TruckState {
    protected int lengthInCentimeters;
    protected int weightInKilograms;
    protected TruckTypeState type;
    protected String color;
    protected OwnerState owner;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    TruckStateImpl() {
    }

    public TruckStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static TruckStateBuilder build() {
        return new TruckStateBuilderImpl();
    }

    public static TruckStateBuilder build(TruckState state) {
        return new TruckStateBuilderImpl(state);
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
        if (!getSizeState().isValid()) {
            return false;
        }
        if ((type == null || !type.isValid())
                || color == null
                || (owner == null || !owner.isValid())) {
            return false;
        }
        return true;
    }

    // Getters
    public int getLengthInCentimeters() { return lengthInCentimeters; }
    public int getWeightInKilograms() { return weightInKilograms; }
    public TruckTypeState getType() { return type; }
    public String getColor() { return color; }
    public OwnerState getOwner() { return owner; }

    // Setters
    public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { checkMutator(mutator); this.lengthInCentimeters = lengthInCentimeters; }
    public void setWeightInKilograms(int weightInKilograms, Object mutator) { checkMutator(mutator); this.weightInKilograms = weightInKilograms; }
    public void setType(TruckTypeState type, Object mutator) { checkMutator(mutator); this.type = type; }
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }
    public void setOwner(OwnerState owner, Object mutator) { checkMutator(mutator); this.owner = owner; }

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

    public VehicleSizeState getSizeState() {
        return new VehicleSizeState() {
            public Certificate certificate() { return certificate(); }

            public int getLengthInCentimeters() { return TruckStateImpl.this.getLengthInCentimeters(); }
            public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { TruckStateImpl.this.setLengthInCentimeters(lengthInCentimeters, mutator); }

            public void encapsulate() { TruckStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { TruckStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                return lengthInCentimeters >= 0;
            }

            @Override
            public boolean equals(Object that) {
               if (this == that) return true;
               if (!(that instanceof TruckStateComparable)) return false;

               return true;
            }

            public boolean equalsValue(Object value) {
                if (this == value) return true;
                if (value == null || getClass() != value.getClass()) return false;

                VehicleSizeStateImpl state = (VehicleSizeStateImpl)value;

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
                return "{lengthInCentimeters=" + lengthInCentimeters + "}";
            }
        };
    }

    @Override
    public boolean equals(Object that) {
       if (this == that) return true;
       if (!(that instanceof TruckStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        TruckStateImpl state = (TruckStateImpl)value;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;
        if (type != null ? !type.equals(state.getType()) : state.getType() != null) return false;
        if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;
        if (owner != null ? !owner.equals(state.getOwner()) : state.getOwner() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lengthInCentimeters;
        result = 31 * result + weightInKilograms;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{lengthInCentimeters=" + lengthInCentimeters +
                ", weightInKilograms=" + weightInKilograms +
                ", type=" + type +
                ", color=" + (color == null ? null : '\'' + color + '\'' ) +
                ", owner=" + owner + "}";
    }
}
