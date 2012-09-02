package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;

public class ForeheadBuilder {
    public final ForeheadStateBuilder builder;

    public ForeheadBuilder() {
        builder = ForeheadStateImpl.build();
    }

    public ForeheadBuilder(ForeheadState state) {
        builder = ForeheadStateImpl.build(state);
    }

    public ForeheadBuilder withBrows(BrowListCreator brows) {
        builder.withBrows(brows.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_(builder));
    }
}
