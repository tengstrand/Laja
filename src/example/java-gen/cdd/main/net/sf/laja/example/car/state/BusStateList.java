package net.sf.laja.example.car.state;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface BusStateList extends List<BusState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
