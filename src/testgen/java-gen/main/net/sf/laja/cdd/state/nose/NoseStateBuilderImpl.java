package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class NoseStateBuilderImpl implements NoseStateBuilder {
    private Object encapsulator;
    private NoseState state;
    private final Certificate certificate;

    NoseStateBuilderImpl() {
        state = new NoseStateImpl();
        certificate = Certificate.get(this);
    }

    public NoseStateBuilderImpl(NoseState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public NoseStateBuilderImpl(NoseState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withNoseDescription(String noseDescription) {
        state.setNoseDescription(noseDescription, encapsulator);
    }

    public void withDetails(String details) {
        state.setDetails(details, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(NoseStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public NoseState getNoseState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }
}
