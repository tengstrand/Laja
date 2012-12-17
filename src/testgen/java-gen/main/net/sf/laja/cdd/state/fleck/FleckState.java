package net.sf.laja.cdd.state.fleck;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface FleckState {
    int getArea(); // (hide)
    void setArea(int area);

    String getColor(); // (hide)
    void setColor(String color);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    Certificate certificate();
}
