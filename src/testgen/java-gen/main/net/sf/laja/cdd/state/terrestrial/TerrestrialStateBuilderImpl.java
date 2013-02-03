package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.eye.EyeStateBuilderImpl;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class TerrestrialStateBuilderImpl implements TerrestrialStateBuilder {
    private Object encapsulator;
    private TerrestrialState state;
    private final Certificate certificate;
    private EyeStateBuilder leftEyeStateBuilder;
    private EyeStateBuilder rightEyeStateBuilder;
    private EyeStateBuilder middleEyeStateBuilder;

    TerrestrialStateBuilderImpl() {
        state = new TerrestrialStateImpl();
        certificate = Certificate.get(this);
    }

    public TerrestrialStateBuilderImpl(TerrestrialState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public TerrestrialStateBuilderImpl(TerrestrialState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withNumberOfLegs(int numberOfLegs) {
        state.setNumberOfLegs(numberOfLegs, encapsulator);
    }

    public void withNumberOfWings(int numberOfWings) {
        state.setNumberOfWings(numberOfWings, encapsulator);
    }

    public void withLeftEye(EyeStateBuilder leftEye) {
        state.setLeftEye(leftEye.getEyeState(certificate), encapsulator);
    }

    public void withRightEye(EyeStateBuilder rightEye) {
        state.setRightEye(rightEye.getEyeState(certificate), encapsulator);
    }

    public void withMiddleEye(EyeStateBuilder middleEye) {
        state.setMiddleEye(middleEye.getEyeState(certificate), encapsulator);
    }

    public void withWeight(int weight) {
        state.setWeight(weight, encapsulator);
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

    public EyeStateBuilder getMiddleEyeStateBuilder() {
        if (middleEyeStateBuilder == null) {
            middleEyeStateBuilder = new EyeStateBuilderImpl(state.getMiddleEye());
        }
        return middleEyeStateBuilder;
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(TerrestrialBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public TerrestrialState getTerrestrialState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TerrestrialStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
