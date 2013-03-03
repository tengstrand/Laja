package net.sf.laja.cdd.behaviour.ear;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TheEarCreator {
    private final EarStateBuilder builder = EarStateImpl.build();

    public class Weight_ {
        public TheEarEncapsulator weight(int weight) {
            builder.withWeight(weight);
            return create();
        }
    }

    public TheEarEncapsulator create() {
        return new TheEarEncapsulator(builder);
     }
}
