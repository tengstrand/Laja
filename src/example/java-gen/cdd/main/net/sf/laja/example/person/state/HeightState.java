package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface HeightState {
    int getHeightInCentimeters();
    void setHeightInCentimeters(int heightInCentimeters, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
