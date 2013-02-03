package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface MonsterState extends MonsterStateComparable, HeadState {
    int getNumberOfLegs();
    void setNumberOfLegs(int numberOfLegs, Object mutator);

    int getNumberOfOwnWings();
    void setNumberOfOwnWings(int numberOfOwnWings, Object mutator);

    double getHeadWeightInGrams();
    void setHeadWeightInGrams(double headWeightInGrams, Object mutator);

    EyeState getLeftEye();
    void setLeftEye(EyeState leftEye, Object mutator);

    EyeState getRightEye();
    void setRightEye(EyeState rightEye, Object mutator);

    EyeState getMidEye(); // (optional)
    void setMidEye(EyeState midEye, Object mutator);

    int getEyeWeightInGrams();
    void setEyeWeightInGrams(int eyeWeightInGrams, Object mutator);

    String getColor();
    void setColor(String color, Object mutator);

    String getDecease(); // (hide)
    void setDecease(String decease, Object mutator);

    NoseStateList getNoses();
    void setNoses(NoseStateList noses, Object mutator);

    BrowStateList getBrows(); // (optional)
    void setBrows(BrowStateList brows, Object mutator);

    EarStateSet getEars(); // (optional)
    void setEars(EarStateSet ears, Object mutator);

    int getLength(); // (optional)
    void setLength(int length, Object mutator);

    boolean getA();
    void setA(boolean a, Object mutator);

    byte getB();
    void setB(byte b, Object mutator);

    short getC();
    void setC(short c, Object mutator);

    char getD();
    void setD(char d, Object mutator);

    int getE(); // (hidden)
    void setE(int e, Object mutator);

    long getF();
    void setF(long f, Object mutator);

    float getG();
    void setG(float g, Object mutator);

    double getH();
    void setH(double h, Object mutator);

    EarStateList getOptionalEars(); // (optional)
    void setOptionalEars(EarStateList optionalEars, Object mutator);

    MouthStateList getMouths();
    void setMouths(MouthStateList mouths, Object mutator);

    int getWeight();
    void setWeight(int weight, Object mutator);

    Boolean getHasEar();
    void setHasEar(Boolean hasEar, Object mutator);

    double getHeadWeight();
    void setHeadWeight(double headWeight, Object mutator);

    ArmState getLeftArm();
    void setLeftArm(ArmState leftArm, Object mutator);

    EyeState getEyeState();

    TerrestrialState getTerrestrialState();
}
