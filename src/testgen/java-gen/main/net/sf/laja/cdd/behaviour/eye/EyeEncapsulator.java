package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;
// Toe

public class EyeEncapsulator implements EyeStateComparable {
    public final EyeStateBuilder builder;

    public EyeEncapsulator(EyeStateBuilder builder) {
        this.builder = builder;
    }

    public Eye asEye() {
        return (Eye)builder.as(new EyeFactory.EyeFactory_(builder));
    }

    public EyeEncapsulator withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
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
