package net.sf.laja.cdd.state.brow;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BrowStateBuilderImpl implements BrowStateBuilder {
    private Object encapsulator;
    private BrowState state;
    private final Certificate certificate;

    BrowStateBuilderImpl() {
        state = new BrowStateImpl();
        certificate = Certificate.get(this);
    }

    public BrowStateBuilderImpl(BrowState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public BrowStateBuilderImpl(BrowState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withArea(int area) {
        state.setArea(area, encapsulator);
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(BrowStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public BrowState getBrowState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
