package net.sf.laja.cdd.state.eye;

import java.math.BigDecimal;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class EyeStateBuilderImpl implements EyeStateBuilder {
    private Object encapsulator;
    private EyeState state;
    private final Certificate certificate;

    EyeStateBuilderImpl() {
        state = new EyeStateImpl();
        certificate = Certificate.get(this);
    }

    public EyeStateBuilderImpl(EyeState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public EyeStateBuilderImpl(EyeState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withEyeWeightInGrams(int eyeWeightInGrams) {
        state.setEyeWeightInGrams(eyeWeightInGrams, encapsulator);
    }

    public void withColor(String color) {
        state.setColor(color, encapsulator);
    }

    public void withDecease(String decease) {
        state.setDecease(decease, encapsulator);
    }

    public void withHasEar(Boolean hasEar) {
        state.setHasEar(hasEar, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(EyeBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public EyeState getEyeState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EyeStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
