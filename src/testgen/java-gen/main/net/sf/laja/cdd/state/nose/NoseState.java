package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface NoseState {
    String getNoseDescription();
    void setNoseDescription(String noseDescription, Object mutator);

    String getDetails();
    void setDetails(String details, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
