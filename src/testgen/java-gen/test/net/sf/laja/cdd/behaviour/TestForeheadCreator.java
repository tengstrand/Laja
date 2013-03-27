package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.ear.*;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class TestForeheadCreator {
    private final ForeheadStateBuilder builder = ForeheadStateImpl.build();

    public class Brow_ {
        public TestForeheadEncapsulator brow(BrowEncapsulator brow) {
            builder.withBrow(brow.builder);
            return create();
        }
    }

    public TestForeheadEncapsulator create() {
        return new TestForeheadEncapsulator(builder);
     }
}
