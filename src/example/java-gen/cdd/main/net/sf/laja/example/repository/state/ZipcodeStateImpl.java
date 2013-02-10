package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ZipcodeStateImpl implements ZipcodeState {
    protected int zipcode;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    ZipcodeStateImpl() {
    }

    public ZipcodeStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static ZipcodeStateBuilder build() {
        return new ZipcodeStateBuilderImpl();
    }

    public static ZipcodeStateBuilder build(ZipcodeState state) {
        return new ZipcodeStateBuilderImpl(state);
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
    public int getZipcode() { return zipcode; }

    // Setters
    public void setZipcode(int zipcode, Object mutator) { checkMutator(mutator); this.zipcode = zipcode; }

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
       if (!(that instanceof ZipcodeStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        ZipcodeStateImpl state = (ZipcodeStateImpl)value;

        if (zipcode != state.getZipcode()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zipcode;

        return result;
    }

    @Override
    public String toString() {
        return "{zipcode=" + zipcode + "}";
    }
}
