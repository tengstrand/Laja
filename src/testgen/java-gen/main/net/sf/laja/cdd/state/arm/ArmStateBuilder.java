package net.sf.laja.cdd.state.arm;

import net.sf.laja.cdd.state.hand.HandStateList;
import net.sf.laja.cdd.state.hand.HandStateListBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface ArmStateBuilder extends ArmStateComparable {
    void withArmLength(int armLength);
    void withArmWeight(double armWeight);
    void withHands(net.sf.laja.cdd.state.hand.HandStateListBuilder listBuilder);
    HandStateListBuilder getHandsStateListBuilder();
    boolean isValid();
    Object as(ArmBehaviourFactory factory, Object... args);
    ArmState getArmState(net.sf.laja.cdd.state.Certificate certificate);
}
