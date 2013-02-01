package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarCreator {
    private final EarStateBuilder builder = EarStateImpl.build();

    public class Weight_ {
        public EarEncapsulator weight(int weight) {
            builder.withWeight(weight);
            return create();
        }
    }

    public EarEncapsulator create() {
        return new EarEncapsulator(builder);
     }
}
