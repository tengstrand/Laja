package net.sf.laja.cdd.state.head;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface HeadStateList extends List<HeadState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
