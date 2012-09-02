package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrow extends TestBrowFactory {
    public TestBrow(BrowState state) {
        super(state);
    }

    // (factory) (list)
    TestBrow asTestBrow() {
        return new TestBrow(state);
    }

    public int getArea() {
        return state.getArea();
    }
}
