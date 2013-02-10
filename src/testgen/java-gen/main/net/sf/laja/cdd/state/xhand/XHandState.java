package net.sf.laja.cdd.state.xhand;

import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface XHandState {
    String getColor();
    void setColor(String color, Object mutator);

    FingerState getFingerState();

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
