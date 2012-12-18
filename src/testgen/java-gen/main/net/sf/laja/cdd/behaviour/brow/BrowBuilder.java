package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateBuilder;
import net.sf.laja.cdd.state.brow.BrowStateBuilderImpl;
import net.sf.laja.cdd.state.brow.BrowStateImpl;

public class BrowBuilder {
    public final BrowStateBuilder builder;

    public BrowBuilder() {
        builder = BrowStateImpl.build();
    }

    public BrowBuilder(BrowState state) {
        builder = new BrowStateBuilderImpl(state);
    }

    public BrowBuilder(BrowState state, Object encapsulator) {
        builder = new BrowStateBuilderImpl(state, encapsulator);
    }

    public BrowBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Brow asBrow() {
        return (Brow)builder.as(new BrowFactory.BrowFactory_(builder));
    }
}
