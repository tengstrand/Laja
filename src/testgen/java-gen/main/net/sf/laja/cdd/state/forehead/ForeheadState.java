package net.sf.laja.cdd.state.forehead;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface ForeheadState {
    BrowStateList getBrows(); // (optional)
    void setBrows(BrowStateList brows, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
