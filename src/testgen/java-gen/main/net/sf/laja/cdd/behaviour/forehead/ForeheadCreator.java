package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateImpl;

public class ForeheadCreator {
    private final ForeheadStateBuilder builder = ForeheadStateImpl.build();

    public ForeheadEncapsulator create() {
        return new ForeheadEncapsulator(builder);
     }
}
