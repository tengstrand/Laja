package net.sf.laja.cdd.state.hair;

import java.util.List;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface HairStateList extends List<HairState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate(Object encapsulator);
    void throwExceptionIfNotEncapsulatedBy(Object encapsulator);
}
