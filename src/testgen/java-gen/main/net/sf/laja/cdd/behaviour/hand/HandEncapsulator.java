package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandEncapsulator {
    public final HandStateBuilder builder;

    public HandEncapsulator(HandStateBuilder builder) {
        this.builder = builder;
    }

    public Hand asHand() {
        return (Hand)builder.as(new HandFactory.HandFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
