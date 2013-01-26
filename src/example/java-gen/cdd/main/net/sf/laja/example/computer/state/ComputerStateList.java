package net.sf.laja.example.computer.state;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface ComputerStateList extends List<ComputerState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate(Object encapsulator);
    void throwExceptionIfNotEncapsulatedBy(Object encapsulator);
}
