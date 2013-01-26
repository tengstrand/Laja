package net.sf.laja.cdd.state.head;

import java.util.Set;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface HeadStateSet extends Set<HeadState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate(Object encapsulator);
    void throwExceptionIfNotEncapsulatedBy(Object encapsulator);
}
