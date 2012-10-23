package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.nose.NoseStateListBuilder;
import net.sf.laja.cdd.state.brow.BrowStateListBuilder;
import net.sf.laja.cdd.state.ear.EarStateListBuilder;
import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface HeadStateBuilder extends EyeStateBuilder, ForeheadStateBuilder {
    void withHeadWeightInGrams(double headWeightInGrams);
    void withLeftEye(EyeStateBuilder leftEye);
    void withRightEye(EyeStateBuilder rightEye);
    void withMidEye(EyeStateBuilder midEye);
    void withEyeWeightInGrams(int eyeWeightInGrams);
    void withColor(String color);
    void withDecease(String decease);
    void withHasEar(Boolean hasEar);
    void withNoses(net.sf.laja.cdd.state.nose.NoseStateListBuilder listBuilder);
    void withBrows(net.sf.laja.cdd.state.brow.BrowStateListBuilder listBuilder);
    void withLength(int length);
    void withA(boolean a);
    void withB(byte b);
    void withC(short c);
    void withD(char d);
    void withE(int e);
    void withF(long f);
    void withG(float g);
    void withH(double h);
    void withEars(net.sf.laja.cdd.state.ear.EarStateListBuilder listBuilder);
    void withMouths(net.sf.laja.cdd.state.mouth.MouthStateListBuilder listBuilder);
    EyeStateBuilder getLeftEyeStateBuilder();
    EyeStateBuilder getRightEyeStateBuilder();
    EyeStateBuilder getMidEyeStateBuilder();
    NoseStateListBuilder getNosesStateListBuilder();
    BrowStateListBuilder getBrowsStateListBuilder();
    EarStateListBuilder getEarsStateListBuilder();
    MouthStateListBuilder getMouthsStateListBuilder();
    boolean isValid();
    Object as(HeadStateBehaviourFactory factory, Object... args);
    HeadState getHeadState(net.sf.laja.cdd.state.Certificate certificate);
}
