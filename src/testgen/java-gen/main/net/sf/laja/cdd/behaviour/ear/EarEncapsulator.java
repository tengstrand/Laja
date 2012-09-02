package net.sf.laja.cdd.behaviour.ear;

import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarEncapsulator {
    public final EarStateBuilder builder;

    public EarEncapsulator(EarStateBuilder builder) {
        this.builder = builder;
    }

    public Ear asEar() {
        return (Ear)builder.as(new EarFactory.EarFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
