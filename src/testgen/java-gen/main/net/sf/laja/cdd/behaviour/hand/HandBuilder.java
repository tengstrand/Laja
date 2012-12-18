package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandBuilder {
    public final HandStateBuilder builder;

    public HandBuilder() {
        builder = HandStateImpl.build();
    }

    public HandBuilder(HandState state) {
        builder = new HandStateBuilderImpl(state);
    }

    public HandBuilder(HandState state, Object encapsulator) {
        builder = new HandStateBuilderImpl(state, encapsulator);
    }

    public HandBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Hand asHand() {
        return (Hand)builder.as(new HandFactory.HandFactory_(builder));
    }
}
