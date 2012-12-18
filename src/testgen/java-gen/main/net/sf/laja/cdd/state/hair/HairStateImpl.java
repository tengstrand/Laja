package net.sf.laja.cdd.state.hair;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class HairStateImpl implements HairState {
    protected int length; // (key)
    protected String color;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    HairStateImpl() {
    }

    public HairStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static HairStateBuilder build() {
        return new HairStateBuilderImpl();
    }

    public static HairStateBuilder build(HairState state) {
        return new HairStateBuilderImpl(state);
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
        if (color == null) {
            return false;
        }
        return true;
    }

    // Getters
    public int getLength() { return length; }
    public String getColor() { return color; }

    // Setters
    public void setLength(int length, Object mutator) { checkMutator(mutator); this.length = length; }
    public void setColor(String color, Object mutator) { checkMutator(mutator); this.color = color; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
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

        HairStateImpl state = (HairStateImpl)o;

        if (length != state.getLength()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HairStateImpl state = (HairStateImpl)o;

        if (length != state.getLength()) return false;
        if (color != null ? !color.equals(state.color) : state.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = length;

        return result;
    }

    public int valueHashCode() {
        int result = length;
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{length=" + length +
                ", color='" + color + '\'' + "}";
    }
}
