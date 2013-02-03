package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;
// Toe

public class LegEncapsulator implements LegStateComparable {
    public final LegStateBuilder builder;

    public LegEncapsulator(LegStateBuilder builder) {
        this.builder = builder;
    }

    public Leg asLeg() {
        return (Leg)builder.as(new LegFactory.LegFactory_(builder));
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
