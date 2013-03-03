package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;
// Toe

public class TheEarEncapsulator implements EarStateComparable {
    public final EarStateBuilder builder;

    public TheEarEncapsulator(EarStateBuilder builder) {
        this.builder = builder;
    }

    public TheEar asTheEar() {
        return (TheEar)builder.as(new TheEarFactory.TheEarFactory_(builder));
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
