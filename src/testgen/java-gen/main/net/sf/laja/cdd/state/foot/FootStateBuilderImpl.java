package net.sf.laja.cdd.state.foot;

import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.toe.ToeStateListBuilder;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class FootStateBuilderImpl implements FootStateBuilder {
    private Object encapsulator;
    private FootState state;
    private final Certificate certificate;
    private ToeStateListBuilder toesStateListBuilder;

    FootStateBuilderImpl() {
        state = new FootStateImpl();
        certificate = Certificate.get(this);
    }

    public FootStateBuilderImpl(FootState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public FootStateBuilderImpl(FootState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withArea(int area) {
        state.setArea(area, encapsulator);
    }

    public void withToes(net.sf.laja.cdd.state.toe.ToeStateListBuilder listBuilder) {
        state.setToes(listBuilder.getStateList(certificate), encapsulator);
    }

    public ToeStateListBuilder getToesStateListBuilder() {
        if (toesStateListBuilder == null) {
            toesStateListBuilder = new ToeStateListBuilder(state.getToes());
        }
        return toesStateListBuilder;
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(FootBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public FootState getFootState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FootStateComparable)) return false;

        return true;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
