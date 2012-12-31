package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.TruckTypeState;
import net.sf.laja.example.car.state.OwnerState;
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

    public CarState getCarState() {
        return new CarState() {
            public Certificate certificate() { return certificate(); }
            public int getLengthInCentimeters() { return TruckStateImpl.this.lengthInCentimeters; }
            public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { TruckStateImpl.this.setLengthInCentimeters(lengthInCentimeters, mutator); }

            public String getName() { return TruckStateImpl.this.type.getTruckName(); }
            public void setName(String name, Object mutator) { TruckStateImpl.this.type.setTruckName(name, mutator); }

            public OwnerState getOwner() { return TruckStateImpl.this.owner; }
            public void setOwner(OwnerState owner, Object mutator) { TruckStateImpl.this.setOwner(owner, mutator); }

            public String getColor() { return TruckStateImpl.this.color; }
            public void setColor(String color, Object mutator) { TruckStateImpl.this.setColor(color, mutator); }

            public void encapsulate() { TruckStateImpl.this.encapsulate(); }
            public void setEncapsulator(Object encapsulator) { TruckStateImpl.this.setEncapsulator(encapsulator); }

            public boolean isValid() {
                return isValid(_encapsulated);
            }

            public boolean isValidAsEncapsulated() {
                        return isValid(true);
            }

            private boolean isValid(boolean encapsulated) {
                if (getName() == null
           || (getOwner() == null || !getOwner().isValid())
           || getColor() == null) {
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

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                net.sf.laja.example.car.state.CarState state = (net.sf.laja.example.car.state.CarState)o;

                if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
                if (type.getTruckName() != null ? !type.getTruckName().equals(state.getName()) : state.getName() != null) return false;
                if (owner != null ? !owner.equals(state.getOwner()) : state.getOwner() != null) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;

                return true;
            }

            public boolean valueEquals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                net.sf.laja.example.car.state.CarState state = (net.sf.laja.example.car.state.CarState)o;

                if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
                if (type.getTruckName() != null ? !type.getTruckName().equals(state.getName()) : state.getName() != null) return false;
                if (owner != null ? !owner.equals(state.getOwner()) : state.getOwner() != null) return false;
                if (color != null ? !color.equals(state.getColor()) : state.getColor() != null) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = lengthInCentimeters;
                result = 31 * result + (type.getTruckName() != null ? type.getTruckName().hashCode() : 0);
                result = 31 * result + (owner != null ? owner.hashCode() : 0);
                result = 31 * result + (color != null ? color.hashCode() : 0);

                return result;
            }

            public int valueHashCode() {
                int result = lengthInCentimeters;
                result = 31 * result + (type.getTruckName() != null ? type.getTruckName().hashCode() : 0);
                result = 31 * result + (owner != null ? owner.hashCode() : 0);
                result = 31 * result + (color != null ? color.hashCode() : 0);

                return result;
            }

            @Override
            public String toString() {
                return "{lengthInCentimeters=" + getLengthInCentimeters() +
                        ", name=" + (getName() == null ? null : '\'' + getName() + '\'' ) +
                        ", owner=" + getOwner() +
                        ", color='" + getColor() + '\'' + "}";
            }
        };
    }

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
        if ((type == null || !type.isValid())
           || color == null
           || (owner == null || !owner.isValid())) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckStateImpl state = (TruckStateImpl)o;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;
        if (type != null ? !type.equals(state.type) : state.type != null) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckStateImpl state = (TruckStateImpl)o;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
        if (weightInKilograms != state.getWeightInKilograms()) return false;
        if (type != null ? !type.equals(state.type) : state.type != null) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;

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

    public int valueHashCode() {
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
