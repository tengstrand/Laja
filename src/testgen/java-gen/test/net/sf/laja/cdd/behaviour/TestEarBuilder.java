package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarBuilder {
    public final EarStateBuilder builder;

    public TestEarBuilder() {
        builder = EarStateImpl.build();
    }

    public TestEarBuilder(EarState state) {
        builder = new EarStateBuilderImpl(state);
    }

    public TestEarBuilder(EarState state, Object encapsulator) {
        builder = new EarStateBuilderImpl(state, encapsulator);
    }

    public TestEarBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestEar asTestEar() {
        return (TestEar)builder.as(new TestEarFactory.TestEarFactory_(builder));
    }
}
