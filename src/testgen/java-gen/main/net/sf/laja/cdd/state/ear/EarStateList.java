package net.sf.laja.cdd.state.ear;

import net.sf.laja.cdd.state.Certificate;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface EarStateList extends List<EarState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
