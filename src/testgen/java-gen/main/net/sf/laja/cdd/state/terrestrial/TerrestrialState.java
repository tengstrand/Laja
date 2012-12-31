package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TerrestrialState {
    int getNumberOfLegs();
    void setNumberOfLegs(int numberOfLegs, Object mutator);

    int getNumberOfWings(); // (hide)
    void setNumberOfWings(int numberOfWings, Object mutator);

    EyeState getLeftEye();
    void setLeftEye(EyeState leftEye, Object mutator);

    EyeState getRightEye(); // (hide)
    void setRightEye(EyeState rightEye, Object mutator);

    EyeState getMiddleEye(); // (optional)
    void setMiddleEye(EyeState middleEye, Object mutator);

    int getWeight(); // (hide)
    void setWeight(int weight, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
