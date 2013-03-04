package net.sf.laja.cdd.state.foot;

;
import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.toe.ToeStateArrayList;
import net.sf.laja.cdd.state.toe.ToeStateList;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class FootStateImpl implements FootState {
    protected int area;
    protected ToeStateList toes;

    private boolean _encapsulated = false;
    private Object _encapsulator;

    FootStateImpl() {
        toes = ToeStateArrayList.emptyList();
    }

    public FootStateImpl(Certificate certificate) {
        this();
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate can not be null");
        }
    }

    public static FootStateBuilder build() {
        return new FootStateBuilderImpl();
    }

    public static FootStateBuilder build(FootState state) {
        return new FootStateBuilderImpl(state);
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
        if ((toes == null || !toes.isValid())) {
            return false;
        }
        return true;
    }

    // Getters
    public int getArea() { return area; }
    public ToeStateList getToes() { return toes; }

    // Setters
    public void setArea(int area, Object mutator) { checkMutator(mutator); this.area = area; }
    public void setToes(ToeStateList toes, Object mutator) { checkMutator(mutator); this.toes.clear(); this.toes.addAll(toes); }

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
       if (!(that instanceof FootStateComparable)) return false;

       return true;
    }

    public boolean equalsValue(Object value) {
        if (this == value) return true;
        if (value == null || getClass() != value.getClass()) return false;

        FootStateImpl state = (FootStateImpl)value;

        if (area != state.getArea()) return false;
        if (toes != null ? !toes.equals(state.getToes()) : state.getToes() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = area;

        return result;
    }

    @Override
    public String toString() {
        return "{area=" + area +
                ", toes=" + toes + "}";
    }
}
