package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.OwnerState;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CarStateImpl implements CarState {
    protected int lengthInCentimeters;
    protected String name;
    protected OwnerState owner;
    protected String color;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    CarStateImpl() {
    }

    public CarStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static CarStateBuilder build() {
        return new CarStateBuilderImpl();
    }

    public static CarStateBuilder build(CarState state) {
        return new CarStateBuilderImpl(state);
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
        if (name == null
           || (owner == null || !owner.isValid())
           || color == null) {
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
    public String getName() { return name; }
    public OwnerState getOwner() { return owner; }
    public String getColor() { return color; }

    // Setters
    public void setLengthInCentimeters(int lengthInCentimeters, Object mutator) { checkMutator(mutator); this.lengthInCentimeters = lengthInCentimeters; }
    public void setName(String name, Object mutator) { checkMutator(mutator); this.name = name; }
    public void setOwner(OwnerState owner, Object mutator) { checkMutator(mutator); this.owner = owner; }
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }

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
       if (!(that instanceof CarStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        CarStateImpl state = (CarStateImpl)value;

        if (lengthInCentimeters != state.getLengthInCentimeters()) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;
        if (owner != null ? !owner.equals(state.owner) : state.owner != null) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lengthInCentimeters;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{lengthInCentimeters=" + lengthInCentimeters +
                ", name=" + (name == null ? null : '\'' + name + '\'' ) +
                ", owner=" + owner +
                ", color='" + color + '\'' + "}";
    }
}
