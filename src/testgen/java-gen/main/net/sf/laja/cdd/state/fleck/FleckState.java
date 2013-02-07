package net.sf.laja.cdd.state.fleck;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface FleckState {
    int getArea(); // (hide)
    void setArea(int area, Object mutator);

    String getColor(); // (hide)
    void setColor(String color, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
