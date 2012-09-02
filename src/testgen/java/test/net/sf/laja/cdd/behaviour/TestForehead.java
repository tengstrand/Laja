package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.ForeheadState;

public class TestForehead extends TestForeheadFactory {
    public TestForehead(ForeheadState state) {
        super(state);
    }

    // (factory)
    public TestForehead asTestForehead() {
        return new TestForehead(state);
    }

    public TestBrowList remove(int index) {
        TestBrowList browList = new TestBrowList(state.getBrows());
        browList.remove(index);
        return browList;
    }
}
