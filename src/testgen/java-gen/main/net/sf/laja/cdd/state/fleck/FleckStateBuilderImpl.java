package net.sf.laja.cdd.state.fleck;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class FleckStateBuilderImpl implements FleckStateBuilder {
    private boolean encapsulated;
    private Object encapsulator;
    private FleckState state;
    private final Certificate certificate;
    private boolean trusted;

    FleckStateBuilderImpl() {
        state = new FleckStateImpl();
        certificate = Certificate.get(this);
    }

    public FleckStateBuilderImpl(FleckState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public FleckStateBuilderImpl(FleckState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withArea(int area) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setArea(area, encapsulator);
    }

    public void withColor(String color) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setColor(color, encapsulator);
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Fleck\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(FleckStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public FleckState getFleckState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }
}
