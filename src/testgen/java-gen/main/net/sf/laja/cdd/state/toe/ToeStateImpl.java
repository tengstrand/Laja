package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ToeStateImpl implements ToeState {
    protected int length; // (key)
    protected int weight;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    ToeStateImpl() {
    }

    public ToeStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static ToeStateBuilder build() {
        return new ToeStateBuilderImpl();
    }

    public static ToeStateBuilder build(ToeState state) {
        return new ToeStateBuilderImpl(state);
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
    public int getLength() { return length; }
    public int getWeight() { return weight; }

    // Setters
    public void setLength(int length, Object mutator) { checkMutator(mutator); this.length = length; }
    public void setWeight(int weight, Object mutator) { checkMutator(mutator); this.weight = weight; }

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

        ToeStateImpl state = (ToeStateImpl)o;

        if (length != state.getLength()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToeStateImpl state = (ToeStateImpl)o;

        if (length != state.getLength()) return false;
        if (weight != state.getWeight()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = length;

        return result;
    }

    public int valueHashCode() {
        int result = length;
        result = 31 * result + weight;

        return result;
    }

    @Override
    public String toString() {
        return "{length=" + length +
                ", weight=" + weight + "}";
    }
}
