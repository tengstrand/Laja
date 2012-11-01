package net.sf.laja.cdd.state.foot;

import net.sf.laja.cdd.state.toe.ToeStateList;
import net.sf.laja.cdd.state.toe.ToeStateListBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class FootStateBuilderImpl implements FootStateBuilder {
    private boolean encapsulated;
    private FootState state;
    private final Certificate certificate;
    private boolean trusted;
    private ToeStateListBuilder toesStateListBuilder;

    FootStateBuilderImpl() {
        state = new FootStateImpl();
        certificate = Certificate.get(this);
    }

    public FootStateBuilderImpl(FootState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public void withArea(int area) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setArea(area);
    }

    public void withToes(net.sf.laja.cdd.state.toe.ToeStateListBuilder listBuilder) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setToes(listBuilder.getStateList(certificate));
    }

    public ToeStateListBuilder getToesStateListBuilder() {
        if (toesStateListBuilder == null) {
            toesStateListBuilder = new ToeStateListBuilder(state.getToes());
        }
        return toesStateListBuilder;
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Foot\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(FootStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public FootState getFootState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }
}
