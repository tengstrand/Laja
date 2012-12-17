package net.sf.laja.cdd.state.leg;

import net.sf.laja.cdd.state.Certificate;
/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface LegState {
    String getLegDescription();
    void setLegDescription(String legDescription);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    Certificate certificate();
}
