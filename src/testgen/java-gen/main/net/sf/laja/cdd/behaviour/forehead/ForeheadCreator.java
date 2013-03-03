package net.sf.laja.cdd.behaviour.forehead;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class ForeheadCreator {
    private final ForeheadStateBuilder builder = ForeheadStateImpl.build();

    public ForeheadEncapsulator create() {
        return new ForeheadEncapsulator(builder);
     }
}
