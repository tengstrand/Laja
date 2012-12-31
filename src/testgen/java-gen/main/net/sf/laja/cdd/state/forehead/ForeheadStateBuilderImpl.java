package net.sf.laja.cdd.state.forehead;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.brow.BrowStateListBuilder;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadStateBuilderImpl implements ForeheadStateBuilder {
    private Object encapsulator;
    private ForeheadState state;
    private final Certificate certificate;
    private BrowStateListBuilder browsStateListBuilder;

    ForeheadStateBuilderImpl() {
        state = new ForeheadStateImpl();
        certificate = Certificate.get(this);
    }

    public ForeheadStateBuilderImpl(ForeheadState state) {
        this.state = state;
        certificate = Certificate.get(this);
    }

    public ForeheadStateBuilderImpl(ForeheadState state, Object encapsulator) {
        this(state);
        this.encapsulator = encapsulator;
    }

    public void withBrows(net.sf.laja.cdd.state.brow.BrowStateListBuilder listBuilder) {
        state.setBrows(listBuilder.getStateList(certificate), encapsulator);
    }

    public BrowStateListBuilder getBrowsStateListBuilder() {
        if (browsStateListBuilder == null) {
            browsStateListBuilder = new BrowStateListBuilder(state.getBrows());
        }
        return browsStateListBuilder;
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(ForeheadStateBehaviourFactory factory, Object... args) {
        return factory.create(state, args);
    }

    public ForeheadState getForeheadState(net.sf.laja.cdd.state.Certificate certificate) {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
