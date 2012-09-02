package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowBuilder {
    public final BrowStateBuilder builder;

    public BrowBuilder() {
        builder = BrowStateImpl.build();
    }

    public BrowBuilder(BrowState state) {
        builder = BrowStateImpl.build(state);
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
