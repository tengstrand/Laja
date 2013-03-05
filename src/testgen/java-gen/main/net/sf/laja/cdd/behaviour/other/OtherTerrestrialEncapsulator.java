package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
// Toe
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;

public class OtherTerrestrialEncapsulator implements TerrestrialStateComparable {
    public final TerrestrialStateBuilder builder;

    public OtherTerrestrialEncapsulator(TerrestrialStateBuilder builder) {
        this.builder = builder;
    }

    public OtherTerrestrial asOtherTerrestrial() {
        return (OtherTerrestrial)builder.as(new OtherTerrestrialFactory.OtherTerrestrialFactory_());
    }

    public OtherTerrestrialEncapsulator withMiddleEye(EyeEncapsulator middleEye) {
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
