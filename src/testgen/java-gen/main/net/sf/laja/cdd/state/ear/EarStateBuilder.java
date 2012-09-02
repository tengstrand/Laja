package net.sf.laja.cdd.state.ear;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface EarStateBuilder {
    void withSize(double size);
    boolean isValid();
    Object as(EarStateBehaviourFactory factory, Object... args);
    EarState getEarState(net.sf.laja.cdd.state.Certificate certificate);
}
