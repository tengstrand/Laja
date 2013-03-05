package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
// Toe
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;

public class TerrestrialEncapsulator implements TerrestrialStateComparable {
    public final TerrestrialStateBuilder builder;

    public TerrestrialEncapsulator(TerrestrialStateBuilder builder) {
        this.builder = builder;
    }

    public Terrestrial asTerrestrial() {
        return (Terrestrial)builder.as(new TerrestrialFactory.TerrestrialFactory_(builder));
    }

    public TerrestrialEncapsulator withMiddleEye(EyeEncapsulator middleEye) {
        builder.withMiddleEye(middleEye.builder);
        return this;
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
