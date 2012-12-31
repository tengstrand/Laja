package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface ToeStateBuilder {
    void withLength(int length);
    void withWeight(int weight);
    boolean isValid();
    Object as(ToeStateBehaviourFactory factory, Object... args);
    ToeState getToeState(net.sf.laja.cdd.state.Certificate certificate);
}
