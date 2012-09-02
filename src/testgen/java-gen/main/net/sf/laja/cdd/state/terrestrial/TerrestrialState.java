package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface TerrestrialState {
    int getNumberOfLegs();
    void setNumberOfLegs(int numberOfLegs);

    int getNumberOfWings(); // (hide)
    void setNumberOfWings(int numberOfWings);

    EyeState getLeftEye();
    void setLeftEye(EyeState leftEye);

    EyeState getRightEye(); // (hide)
    void setRightEye(EyeState rightEye);

    EyeState getMiddleEye(); // (optional)
    void setMiddleEye(EyeState middleEye);

    int getWeight(); // (hide)
    void setWeight(int weight);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
}
