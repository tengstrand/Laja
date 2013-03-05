package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;
// Toe

public class HandEncapsulator implements HandStateComparable {
    public final HandStateBuilder builder;

    public HandEncapsulator(HandStateBuilder builder) {
        this.builder = builder;
    }

    public Hand asHand() {
        return (Hand)builder.as(new HandFactory.HandFactory_());
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
