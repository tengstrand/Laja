package net.sf.laja.cdd.state.arm;

import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface ArmStateList extends List<ArmState> {
    Certificate certificate();
    boolean isValid();
    void encapsulate();
}
