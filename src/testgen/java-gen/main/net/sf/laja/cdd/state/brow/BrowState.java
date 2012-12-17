package net.sf.laja.cdd.state.brow;

import net.sf.laja.cdd.state.Certificate;
/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface BrowState {
    int getArea();
    void setArea(int area);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    Certificate certificate();
}
