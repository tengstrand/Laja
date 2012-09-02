package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateBuilder;

public class BrowFactory extends BrowValueFactory {
    public BrowFactory(BrowState state) {
        super(state);
    }

    public BrowFactory(BrowState state, BrowStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
