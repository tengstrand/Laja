package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;

public class ForeheadCreator {
    private final ForeheadStateBuilder builder = ForeheadStateImpl.build();

    public ForeheadEncapsulator create() {
        return new ForeheadEncapsulator(builder);
     }
}
