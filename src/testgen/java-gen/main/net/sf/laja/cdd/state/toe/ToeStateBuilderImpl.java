package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class ToeStateBuilderImpl implements ToeStateBuilder {
    private boolean encapsulated;
    private ToeState state;
    private final Certificate certificate;
    private boolean trusted;

    ToeStateBuilderImpl() {
        state = new ToeStateImpl();
        certificate = Certificate.get(this);
    }

    public ToeStateBuilderImpl(ToeState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withLength(int length) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setLength(length);
    }

    public void withWeight(int weight) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setWeight(weight);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Toe\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(ToeStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public ToeState getToeState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }
}
