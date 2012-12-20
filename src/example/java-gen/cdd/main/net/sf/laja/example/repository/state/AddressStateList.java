package net.sf.laja.example.repository.state;

import java.util.List;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface AddressStateList extends List<AddressState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate(Object encapsulator);
    void throwExceptionIfNotEncapsulatedBy(Object encapsulator);
}
