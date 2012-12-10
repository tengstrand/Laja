package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;
/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface NoseState {
    Certificate certificate();
    String getNoseDescription();
    void setNoseDescription(String noseDescription);

    String getDetails();
    void setDetails(String details);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
}
