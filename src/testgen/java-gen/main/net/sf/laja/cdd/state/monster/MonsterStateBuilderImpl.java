package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.head.HeadStateBehaviourFactory;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.eye.EyeStateBehaviourFactory;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadStateBehaviourFactory;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.nose.NoseStateListBuilder;
import net.sf.laja.cdd.state.brow.BrowStateListBuilder;
import net.sf.laja.cdd.state.ear.EarStateListBuilder;
import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;
import net.sf.laja.cdd.state.arm.ArmStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilderImpl;
import net.sf.laja.cdd.state.arm.ArmStateBuilderImpl;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilderImpl;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MonsterStateBuilderImpl implements MonsterStateBuilder {
    private Object encapsulator;
    private MonsterState state;
    private final Certificate certificate;
    private EyeStateBuilder leftEyeStateBuilder;
    private EyeStateBuilder rightEyeStateBuilder;
    private EyeStateBuilder midEyeStateBuilder;
    private NoseStateListBuilder nosesStateListBuilder;
    private BrowStateListBuilder browsStateListBuilder;
    private EarStateListBuilder earsStateListBuilder;
    private MouthStateListBuilder mouthsStateListBuilder;
    private ArmStateBuilder leftArmStateBuilder;

    MonsterStateBuilderImpl() {
        state = new MonsterStateImpl();
        certificate = Certificate.get(this);
    }

    public MonsterStateBuilderImpl(MonsterState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public MonsterStateBuilderImpl(MonsterState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public EyeStateBuilder eyeStateBuilder() {
        return new EyeStateBuilderImpl(state.getEyeState());
    }

    public TerrestrialStateBuilder terrestrialStateBuilder() {
        return new TerrestrialStateBuilderImpl(state.getTerrestrialState());
    }

    public void withNumberOfLegs(int numberOfLegs) {
        state.setNumberOfLegs(numberOfLegs, encapsulator);
    }

    public void withNumberOfOwnWings(int numberOfOwnWings) {
        state.setNumberOfOwnWings(numberOfOwnWings, encapsulator);
    }

    public void withHeadWeightInGrams(double headWeightInGrams) {
        state.setHeadWeightInGrams(headWeightInGrams, encapsulator);
    }

    public void withLeftEye(EyeStateBuilder leftEye) {
        state.setLeftEye(leftEye.getEyeState(certificate), encapsulator);
    }

    public void withRightEye(EyeStateBuilder rightEye) {
        state.setRightEye(rightEye.getEyeState(certificate), encapsulator);
    }

    public void withMidEye(EyeStateBuilder midEye) {
        state.setMidEye(midEye.getEyeState(certificate), encapsulator);
    }

    public void withEyeWeightInGrams(int eyeWeightInGrams) {
        state.setEyeWeightInGrams(eyeWeightInGrams, encapsulator);
    }

    public void withEyeWeightInGrams(String eyeWeightInGrams) {
        state.setEyeWeightInGrams(Integer.valueOf(eyeWeightInGrams), encapsulator);
    }

    public void withColor(String color) {
        state.setColor(color, encapsulator);
    }

    public void withColor(BigDecimal color) {
        state.setColor(color.toString(), encapsulator);
    }

    public void withColor(int color) {
        state.setColor(String.valueOf(color), encapsulator);
    }

    public void withDecease(String decease) {
        state.setDecease(decease, encapsulator);
    }

    public void withDecease(int decease) {
        state.setDecease(String.valueOf(decease), encapsulator);
    }

    public void withNoses(net.sf.laja.cdd.state.nose.NoseStateListBuilder listBuilder) {
        state.setNoses(listBuilder.getStateList(certificate), encapsulator);
    }

    public void withBrows(net.sf.laja.cdd.state.brow.BrowStateListBuilder listBuilder) {
        state.setBrows(listBuilder.getStateList(certificate), encapsulator);
    }

    public void withLength(int length) {
        state.setLength(length, encapsulator);
    }

    public void withA(boolean a) {
        state.setA(a, encapsulator);
    }

    public void withB(byte b) {
        state.setB(b, encapsulator);
    }

    public void withC(short c) {
        state.setC(c, encapsulator);
    }

    public void withD(char d) {
        state.setD(d, encapsulator);
    }

    public void withE(int e) {
        state.setE(e, encapsulator);
    }

    public void withF(long f) {
        state.setF(f, encapsulator);
    }

    public void withG(float g) {
        state.setG(g, encapsulator);
    }

    public void withH(double h) {
        state.setH(h, encapsulator);
    }

    public void withEars(net.sf.laja.cdd.state.ear.EarStateListBuilder listBuilder) {
        state.setEars(listBuilder.getStateList(certificate), encapsulator);
    }

    public void withMouths(net.sf.laja.cdd.state.mouth.MouthStateListBuilder listBuilder) {
        state.setMouths(listBuilder.getStateList(certificate), encapsulator);
    }

    public void withWeight(int weight) {
        state.setWeight(weight, encapsulator);
    }

    public void withHasEar(Boolean hasEar) {
        state.setHasEar(hasEar, encapsulator);
    }

    public void withHeadWeight(double headWeight) {
        state.setHeadWeight(headWeight, encapsulator);
    }

    public void withLeftArm(ArmStateBuilder leftArm) {
        state.setLeftArm(leftArm.getArmState(certificate), encapsulator);
    }

    public EyeStateBuilder getLeftEyeStateBuilder() {
        if (leftEyeStateBuilder == null) {
            leftEyeStateBuilder = new EyeStateBuilderImpl(state.getLeftEye());
        }
        return leftEyeStateBuilder;
    }

    public EyeStateBuilder getRightEyeStateBuilder() {
        if (rightEyeStateBuilder == null) {
            rightEyeStateBuilder = new EyeStateBuilderImpl(state.getRightEye());
        }
        return rightEyeStateBuilder;
    }

    public EyeStateBuilder getMidEyeStateBuilder() {
        if (midEyeStateBuilder == null) {
            midEyeStateBuilder = new EyeStateBuilderImpl(state.getMidEye());
        }
        return midEyeStateBuilder;
    }

    public NoseStateListBuilder getNosesStateListBuilder() {
        if (nosesStateListBuilder == null) {
            nosesStateListBuilder = new NoseStateListBuilder(state.getNoses());
        }
        return nosesStateListBuilder;
    }

    public BrowStateListBuilder getBrowsStateListBuilder() {
        if (browsStateListBuilder == null) {
            browsStateListBuilder = new BrowStateListBuilder(state.getBrows());
        }
        return browsStateListBuilder;
    }

    public EarStateListBuilder getEarsStateListBuilder() {
        if (earsStateListBuilder == null) {
            earsStateListBuilder = new EarStateListBuilder(state.getEars());
        }
        return earsStateListBuilder;
    }

    public MouthStateListBuilder getMouthsStateListBuilder() {
        if (mouthsStateListBuilder == null) {
            mouthsStateListBuilder = new MouthStateListBuilder(state.getMouths());
        }
        return mouthsStateListBuilder;
    }

    public ArmStateBuilder getLeftArmStateBuilder() {
        if (leftArmStateBuilder == null) {
            leftArmStateBuilder = new ArmStateBuilderImpl(state.getLeftArm());
        }
        return leftArmStateBuilder;
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(MonsterStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(HeadStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(EyeStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public Object as(ForeheadStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public MonsterState getMonsterState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    public HeadState getHeadState(Certificate certificate) {
        return state;
    }

    public EyeState getEyeState(Certificate certificate) {
        return state;
    }

    public ForeheadState getForeheadState(Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
