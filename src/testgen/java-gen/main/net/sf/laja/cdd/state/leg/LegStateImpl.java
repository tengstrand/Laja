package net.sf.laja.cdd.state.leg;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class LegStateImpl implements LegState {
    protected String legDescription;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    LegStateImpl() {
    }

    public LegStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static LegStateBuilder build() {
        return new LegStateBuilderImpl();
    }

    public static LegStateBuilder build(LegState state) {
        return new LegStateBuilderImpl(state);
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
        if (legDescription == null) {
            return false;
        }
        return true;
    }

    // Getters
    public String getLegDescription() { return legDescription; }

    // Setters
    public void setLegDescription(String legDescription, Object mutator) { checkMutator(mutator); this.legDescription = legDescription; }

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

        LegStateImpl state = (LegStateImpl)obj;

        if (legDescription != null ? !legDescription.equals(state.legDescription) : state.legDescription != null) return false;

        return true;
    }

    public boolean equalsValue(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LegStateImpl state = (LegStateImpl)obj;

        if (legDescription != null ? !legDescription.equals(state.legDescription) : state.legDescription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = legDescription != null ? legDescription.hashCode() : 0;

        return result;
    }

    @Override
    public String toString() {
        return "{legDescription=" + legDescription + "}";
    }
}
