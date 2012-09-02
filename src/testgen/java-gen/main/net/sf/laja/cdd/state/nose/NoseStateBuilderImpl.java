package net.sf.laja.cdd.state.nose;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class NoseStateBuilderImpl implements NoseStateBuilder {
    private boolean encapsulated;
    private NoseState state;
    private final Certificate certificate;
    private boolean trusted;

    NoseStateBuilderImpl() {
        state = new NoseStateImpl();
        certificate = Certificate.get(this);
    }

    public NoseStateBuilderImpl(NoseState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withNoseDescription(String noseDescription) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setNoseDescription(noseDescription);
    }

    public void withDetails(String details) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setDetails(details);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Nose\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(NoseStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public NoseState getNoseState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }
}
