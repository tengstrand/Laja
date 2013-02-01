package net.sf.laja.cdd.state.ear;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class EarStateBuilderImpl implements EarStateBuilder {
    private Object encapsulator;
    private EarState state;
    private final Certificate certificate;

    EarStateBuilderImpl() {
        state = new EarStateImpl();
        certificate = Certificate.get(this);
    }

    public EarStateBuilderImpl(EarState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public EarStateBuilderImpl(EarState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withSize(double size) {
        state.setSize(size, encapsulator);
    }

    public void withWeight(int weight) {
        state.setWeight(weight, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(EarBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public EarState getEarState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
