package net.sf.laja.cdd.behaviour.xhand;

import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;
import net.sf.laja.cdd.state.finger.FingerState;

public class XHandBuilder {
    public final XHandStateBuilder builder;

    public XHandBuilder() {
        builder = XHandStateImpl.build();
    }

    public XHandBuilder(XHandState state) {
        builder = new XHandStateBuilderImpl(state);
    }

    public XHandBuilder(XHandState state, Object encapsulator) {
        builder = new XHandStateBuilderImpl(state, encapsulator);
    }

    public XHandBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public XHand asXHand() {
        return (XHand)builder.as(new XHandFactory.XHandFactory_(builder));
    }
}
