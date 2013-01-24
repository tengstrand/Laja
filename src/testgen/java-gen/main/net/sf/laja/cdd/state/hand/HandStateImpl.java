package net.sf.laja.cdd.state.hand;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HandStateImpl implements HandState {
    protected int area; // (key)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    HandStateImpl() {
    }

    public HandStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static HandStateBuilder build() {
        return new HandStateBuilderImpl();
    }

    public static HandStateBuilder build(HandState state) {
        return new HandStateBuilderImpl(state);
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
        return true;
    }

    // Getters
    public int getArea() { return area; }

    // Setters
    public void setArea(int area, Object mutator) { checkMutator(mutator); this.area = area; }

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        HandStateImpl state = (HandStateImpl)obj;

        if (area != state.getArea()) return false;

        return true;
    }

    public boolean equalsValue(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        HandStateImpl state = (HandStateImpl)obj;

        if (area != state.getArea()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = area;

        return result;
    }

    @Override
    public String toString() {
        return "{area=" + area + "}";
    }
}
