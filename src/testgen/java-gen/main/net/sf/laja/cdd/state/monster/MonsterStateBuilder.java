package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.nose.NoseStateListBuilder;
import net.sf.laja.cdd.state.brow.BrowStateListBuilder;
import net.sf.laja.cdd.state.ear.EarStateSetBuilder;
import net.sf.laja.cdd.state.ear.EarStateListBuilder;
import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;
import net.sf.laja.cdd.state.arm.ArmStateBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface MonsterStateBuilder {
    HeadStateBuilder getHeadStateBuilder();
    void withNumberOfLegs(int numberOfLegs);
    void withNumberOfOwnWings(int numberOfOwnWings);
    void withHeadWeightInGrams(double headWeightInGrams);
    void withLeftEye(EyeStateBuilder leftEye);
    void withRightEye(EyeStateBuilder rightEye);
    void withMidEye(EyeStateBuilder midEye);
    void withEyeWeightInGrams(int eyeWeightInGrams);
    void withColor(String color);
    void withDecease(String decease);
    void withNoses(net.sf.laja.cdd.state.nose.NoseStateListBuilder listBuilder);
    void withBrows(net.sf.laja.cdd.state.brow.BrowStateListBuilder listBuilder);
    void withEars(net.sf.laja.cdd.state.ear.EarStateSetBuilder setBuilder);
    void withLength(int length);
    void withA(boolean a);
    void withB(byte b);
    void withC(short c);
    void withD(char d);
    void withE(int e);
    void withF(long f);
    void withG(float g);
    void withH(double h);
    void withOptionalEars(net.sf.laja.cdd.state.ear.EarStateListBuilder listBuilder);
    void withMouths(net.sf.laja.cdd.state.mouth.MouthStateListBuilder listBuilder);
    void withWeight(int weight);
    void withHasEar(Boolean hasEar);
    void withHeadWeight(double headWeight);
    void withLeftArm(ArmStateBuilder leftArm);
    EyeStateBuilder getLeftEyeStateBuilder();
    EyeStateBuilder getRightEyeStateBuilder();
    EyeStateBuilder getMidEyeStateBuilder();
    NoseStateListBuilder getNosesStateListBuilder();
    BrowStateListBuilder getBrowsStateListBuilder();
    EarStateSetBuilder getEarsStateSetBuilder();
    EarStateListBuilder getOptionalEarsStateListBuilder();
    MouthStateListBuilder getMouthsStateListBuilder();
    ArmStateBuilder getLeftArmStateBuilder();
    boolean isValid();
    Object as(MonsterBehaviourFactory factory, Object... args);
    MonsterState getMonsterState(net.sf.laja.cdd.state.Certificate certificate);
}
