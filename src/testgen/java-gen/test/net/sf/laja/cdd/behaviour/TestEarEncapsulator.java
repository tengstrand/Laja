package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;
// Toe

public class TestEarEncapsulator implements EarStateComparable {
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
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
