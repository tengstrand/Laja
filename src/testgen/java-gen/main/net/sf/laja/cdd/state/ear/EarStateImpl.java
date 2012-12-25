package net.sf.laja.cdd.state.ear;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class EarStateImpl implements EarState {
    protected double size; // (hide)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    EarStateImpl() {
    }

    public EarStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static EarStateBuilder build() {
        return new EarStateBuilderImpl();
    }

    public static EarStateBuilder build(EarState state) {
        return new EarStateBuilderImpl(state);
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
    public double getSize() { return size; }

    // Setters
    public void setSize(double size, Object mutator) { checkMutator(mutator); this.size = size; }

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

        EarStateImpl state = (EarStateImpl)o;

        if (size != state.getSize()) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EarStateImpl state = (EarStateImpl)o;

        if (size != state.getSize()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)size;

        return result;
    }

    public int valueHashCode() {
        int result = (int)size;

        return result;
    }

    @Override
    public String toString() {
        return "{size=" + size + "}";
    }
}
