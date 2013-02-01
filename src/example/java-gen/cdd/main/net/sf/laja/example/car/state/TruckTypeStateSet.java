package net.sf.laja.example.car.state;

import java.util.Set;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TruckTypeStateSet extends Set<TruckTypeState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate(Object encapsulator);
    void throwExceptionIfNotEncapsulatedBy(Object encapsulator);
}