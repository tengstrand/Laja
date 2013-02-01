package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.behaviour.ear.EarFactory;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarEncapsulator {
    public final EarStateBuilder builder;

    public TestEarEncapsulator(EarStateBuilder builder) {
        this.builder = builder;
    }

    public TestEar asTestEar() {
        return (TestEar)builder.as(new TestEarFactory.TestEarFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
