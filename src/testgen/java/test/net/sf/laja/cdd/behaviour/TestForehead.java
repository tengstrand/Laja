package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;

public class TestForehead extends TestForeheadFactory {
    private final TestBrowList brows;

    public TestForehead(ForeheadState state) {
        super(state);
        BrowStateList browStates = state.getBrows();
        brows = new TestBrowList(browStates);
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

    public TestBrowList getBrows() {
        return brows;
    }
}
