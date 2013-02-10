package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class NoseStateImpl implements NoseState {
    protected String noseDescription;
    protected String details;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    NoseStateImpl() {
    }

    public NoseStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static NoseStateBuilder build() {
        return new NoseStateBuilderImpl();
    }

    public static NoseStateBuilder build(NoseState state) {
        return new NoseStateBuilderImpl(state);
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
        if (noseDescription == null
           || details == null) {
            return false;
        }
        return true;
    }

    // Getters
    public String getNoseDescription() { return noseDescription; }
    public String getDetails() { return details; }

    // Setters
    public void setNoseDescription(String noseDescription, Object mutator) { checkMutator(mutator); this.noseDescription = noseDescription; }
    public void setDetails(String details, Object mutator) { checkMutator(mutator); this.details = details; }

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
       if (!(that instanceof NoseStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        NoseStateImpl state = (NoseStateImpl)value;

        if (noseDescription != null ? !noseDescription.equals(state.getNoseDescription()) : state.getNoseDescription() != null) return false;
        if (details != null ? !details.equals(state.getDetails()) : state.getDetails() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noseDescription != null ? noseDescription.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "{noseDescription=" + (noseDescription == null ? null : '\'' + noseDescription + '\'' ) +
                ", details='" + details + '\'' + "}";
    }
}
