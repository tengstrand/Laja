package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;
// Toe

public class NoseEncapsulator implements NoseStateComparable {
    public final NoseStateBuilder builder;

    public NoseEncapsulator(NoseStateBuilder builder) {
        this.builder = builder;
    }

    public Nose asNose(int extraParameter) {
        return (Nose)builder.as(new NoseFactory.NoseFactory_(), extraParameter);
    }

    public BigNose asBigNose() {
        return (BigNose)builder.as(new NoseFactory.BigNoseFactory_());
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
