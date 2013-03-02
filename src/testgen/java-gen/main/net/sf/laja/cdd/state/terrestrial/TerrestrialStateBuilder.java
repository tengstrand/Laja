package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TerrestrialStateBuilder {
    void withNumberOfLegs(int numberOfLegs);
    void withNumberOfWings(int numberOfWings);
    void withLeftEye(EyeStateBuilder leftEye);
    void withRightEye(EyeStateBuilder rightEye);
    void withMiddleEye(EyeStateBuilder middleEye);
    void withWeight(int weight);
    EyeStateBuilder getLeftEyeStateBuilder();
    EyeStateBuilder getRightEyeStateBuilder();
    EyeStateBuilder getMiddleEyeStateBuilder();
    boolean isValid();
    Object as(TerrestrialBehaviourFactory factory, Object... args);
    TerrestrialState getTerrestrialState(net.sf.laja.cdd.state.Certificate certificate);
}
