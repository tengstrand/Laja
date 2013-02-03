package net.sf.laja.cdd.state.mouth;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface MouthStateBuilder extends MouthStateComparable {
    void withNumberOfTeeth(int numberOfTeeth);
    void withWidth(int width);
    void withHeight(int height);
    void withColor(String color);
    boolean isValid();
    Object as(MouthBehaviourFactory factory, Object... args);
    MouthState getMouthState(net.sf.laja.cdd.state.Certificate certificate);
}
