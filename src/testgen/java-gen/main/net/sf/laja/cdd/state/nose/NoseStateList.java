package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface NoseStateList extends List<NoseState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
