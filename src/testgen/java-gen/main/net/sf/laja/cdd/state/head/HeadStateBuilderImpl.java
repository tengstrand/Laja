package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.ear.EarStateListBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilderImpl;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilderImpl;
import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;
import net.sf.laja.cdd.state.nose.NoseStateListBuilder;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HeadStateBuilderImpl implements HeadStateBuilder {
    private Object encapsulator;
    private HeadState state;
    private final Certificate certificate;
    private EyeStateBuilder leftEyeStateBuilder;
    private EyeStateBuilder rightEyeStateBuilder;
    private EyeStateBuilder midEyeStateBuilder;
    private NoseStateListBuilder nosesStateListBuilder;
    private ForeheadStateBuilder foreheadStateBuilder;
    private EarStateListBuilder earsStateListBuilder;
    private MouthStateListBuilder mouthsStateListBuilder;

    HeadStateBuilderImpl() {
        state = new HeadStateImpl();
        certificate = Certificate.get(this);
    }

    public HeadStateBuilderImpl(HeadState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public HeadStateBuilderImpl(HeadState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
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

    public void withNoses(net.sf.laja.cdd.state.nose.NoseStateListBuilder listBuilder) {
        state.setNoses(listBuilder.getStateList(certificate), encapsulator);
    }

    public void withForehead(ForeheadStateBuilder forehead) {
        state.setForehead(forehead.getForeheadState(certificate), encapsulator);
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

    public ForeheadStateBuilder getForeheadStateBuilder() {
        if (foreheadStateBuilder == null) {
            foreheadStateBuilder = new ForeheadStateBuilderImpl(state.getForehead());
        }
        return foreheadStateBuilder;
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

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(HeadBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public HeadState getHeadState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HeadStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
