package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseEncapsulator {
    public final NoseStateBuilder builder;

    public NoseEncapsulator(NoseStateBuilder builder) {
        this.builder = builder;
    }

    public Nose asNose(int extraParameter) {
        return (Nose)builder.as(new NoseFactory.NoseFactory_(builder), extraParameter);
    }

    public BigNose asBigNose() {
        return (BigNose)builder.as(new NoseFactory.BigNoseFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
