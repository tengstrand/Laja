package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarCreator {
    private final EarStateBuilder builder = EarStateImpl.build();

    public EarEncapsulator create() {
        return new EarEncapsulator(builder);
     }
}
