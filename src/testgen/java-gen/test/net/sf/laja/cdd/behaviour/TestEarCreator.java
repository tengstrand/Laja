package net.sf.laja.cdd.behaviour;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarCreator {
    private final EarStateBuilder builder = EarStateImpl.build();

    public class Weight_ {
        public TestEarEncapsulator weight(int weight) {
            builder.withWeight(weight);
            return create();
        }
    }

    public TestEarEncapsulator create() {
        return new TestEarEncapsulator(builder);
     }
}
