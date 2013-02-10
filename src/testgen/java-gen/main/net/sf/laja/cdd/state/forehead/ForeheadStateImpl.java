package net.sf.laja.cdd.state.forehead;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.ear.EarStateHashSet;
import net.sf.laja.cdd.state.brow.BrowStateArrayList;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadStateImpl implements ForeheadState {
    protected BrowStateList brows; // (optional)
    protected EarStateSet ears; // (optional)

    private boolean _encapsulated = false;
    private Object _encapsulator;

    ForeheadStateImpl() {
        ears = EarStateHashSet.emptySet();
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
    public EarStateSet getEars() { return ears; }

    // Setters
    public void setBrows(BrowStateList brows, Object mutator) { checkMutator(mutator); this.brows.clear(); this.brows.addAll(brows); }
    public void setEars(EarStateSet ears, Object mutator) { checkMutator(mutator); this.ears.clear(); this.ears.addAll(ears); }

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
       if (!(that instanceof ForeheadStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        ForeheadStateImpl state = (ForeheadStateImpl)value;

        if (brows != null ? !brows.equals(state.getBrows()) : state.getBrows() != null) return false;
        if (ears != null ? !ears.equals(state.getEars()) : state.getEars() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{brows=" + brows +
                ", ears=" + ears + "}";
    }
}
