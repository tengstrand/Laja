package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateImpl;

public class TestForeheadCreator {
    private final ForeheadStateBuilder builder = ForeheadStateImpl.build();

    public TestForeheadEncapsulator create() {
        return new TestForeheadEncapsulator(builder);
     }
}
