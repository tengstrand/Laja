package net.sf.laja.cdd.state.forehead;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.brow.BrowStateListImpl;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadStateImpl implements ForeheadState {
    protected BrowStateList brows; // (optional)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    ForeheadStateImpl() {
        brows = BrowStateListImpl.emptyList();
    }

    public ForeheadStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static ForeheadStateBuilder build() {
        return new ForeheadStateBuilderImpl();
    }

    public static ForeheadStateBuilder build(ForeheadState state) {
        return new ForeheadStateBuilderImpl(state);
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
    public BrowStateList getBrows() { return brows; }

    // Setters
    public void setBrows(BrowStateList brows, Object mutator) { checkMutator(mutator); this.brows.clear(); this.brows.addAll(brows); }

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

        ForeheadStateImpl state = (ForeheadStateImpl)o;

        if (brows != null ? !brows.equals(state.brows) : state.brows != null) return false;

        return true;
    }

    public boolean valueEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForeheadStateImpl state = (ForeheadStateImpl)o;

        if (brows != null ? !brows.equals(state.brows) : state.brows != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brows != null ? brows.hashCode() : 0;

        return result;
    }

    public int valueHashCode() {
        int result = brows != null ? brows.hashCode() : 0;

        return result;
    }

    @Override
    public String toString() {
        return "{brows=" + brows + "}";
    }
}
