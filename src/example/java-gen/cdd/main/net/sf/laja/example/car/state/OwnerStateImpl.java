package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class OwnerStateImpl implements OwnerState {
    protected long ssn;
    protected String name;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    OwnerStateImpl() {
    }

    public OwnerStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static OwnerStateBuilder build() {
        return new OwnerStateBuilderImpl();
    }

    public static OwnerStateBuilder build(OwnerState state) {
        return new OwnerStateBuilderImpl(state);
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
        return ssn >= 190000000000L;
    }

    // Getters
    public long getSsn() { return ssn; }
    public String getName() { return name; }

    // Setters
    public void setSsn(long ssn, Object mutator) { checkMutator(mutator); this.ssn = ssn; }
    public void setName(String name, Object mutator) { checkMutator(mutator); this.name = name; }

    private void checkMutator(Object mutator) {
        if (mutator != _encapsulator) {
            throw new IllegalStateException("The state can only be mutated by instance of " + (_encapsulator == null ? null : _encapsulator.getClass().getName()));
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

        OwnerStateImpl state = (OwnerStateImpl)o;

        if (ssn != state.getSsn()) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerStateImpl state = (OwnerStateImpl)o;

        if (ssn != state.getSsn()) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    public int valueHashCode() {
        int result = (int)(ssn ^ (ssn >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{ssn=" + ssn +
                ", name='" + name + '\'' + "}";
    }
}
