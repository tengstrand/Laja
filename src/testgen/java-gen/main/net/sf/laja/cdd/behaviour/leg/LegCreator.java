package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegCreator {
    private final LegStateBuilder builder = LegStateImpl.build();

    public class LegDescription_ {
        public LegEncapsulator legDescription(String legDescription) {
            builder.withLegDescription(legDescription);
            return create();
        }
    }

    public LegEncapsulator create() {
        return new LegEncapsulator(builder);
     }
}
