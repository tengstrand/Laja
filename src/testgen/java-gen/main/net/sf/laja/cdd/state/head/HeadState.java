package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface HeadState extends EyeState, ForeheadState {
    Certificate certificate();
    double getHeadWeightInGrams();
    void setHeadWeightInGrams(double headWeightInGrams);

    EyeState getLeftEye();
    void setLeftEye(EyeState leftEye);

    EyeState getRightEye();
    void setRightEye(EyeState rightEye);

    EyeState getMidEye(); // (optional)
    void setMidEye(EyeState midEye);

    int getEyeWeightInGrams();
    void setEyeWeightInGrams(int eyeWeightInGrams);

    String getColor();
    void setColor(String color);

    String getDecease(); // (hide)
    void setDecease(String decease);

    Boolean getHasEar(); // (optional)
    void setHasEar(Boolean hasEar);

    NoseStateList getNoses();
    void setNoses(NoseStateList noses);

    BrowStateList getBrows(); // (optional)
    void setBrows(BrowStateList brows);

    int getLength(); // (optional)
    void setLength(int length);

    boolean getA();
    void setA(boolean a);

    byte getB();
    void setB(byte b);

    short getC();
    void setC(short c);

    char getD();
    void setD(char d);

    int getE(); // (hidden)
    void setE(int e);

    long getF();
    void setF(long f);

    float getG();
    void setG(float g);

    double getH();
    void setH(double h);

    EarStateList getEars(); // (optional)
    void setEars(EarStateList ears);

    MouthStateList getMouths();
    void setMouths(MouthStateList mouths);
}
