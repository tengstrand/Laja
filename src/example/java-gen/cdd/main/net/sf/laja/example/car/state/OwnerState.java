package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface OwnerState {
    long getSsn();
    void setSsn(long ssn, Object mutator);

    String getName();
    void setName(String name, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
