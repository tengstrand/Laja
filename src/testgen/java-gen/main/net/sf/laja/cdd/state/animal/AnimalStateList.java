package net.sf.laja.cdd.state.animal;

import net.sf.laja.cdd.state.Certificate;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface AnimalStateList extends List<AnimalState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
