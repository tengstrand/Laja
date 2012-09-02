package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateBuilder;

public class TestBrowFactory extends TestBrowValueFactory {
    public TestBrowFactory(BrowState state) {
        super(state);
    }

    public TestBrowFactory(BrowState state, BrowStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
