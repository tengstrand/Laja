package net.sf.laja.cdd.state.leg;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface LegStateBuilder {
    void withLegDescription(String legDescription);
    boolean isValid();
    Object as(LegStateBehaviourFactory factory, Object... args);
    LegState getLegState(net.sf.laja.cdd.state.Certificate certificate);
}
