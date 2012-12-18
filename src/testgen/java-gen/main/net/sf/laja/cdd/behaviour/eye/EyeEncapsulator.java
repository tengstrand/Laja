package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.state.eye.*;
import net.sf.laja.cdd.behaviour.scaryeye.ScaryEye;
import net.sf.laja.cdd.state.eye.EyeState;
import java.math.BigDecimal;

public class EyeEncapsulator {
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
    public String toString() {
        return builder.toString();
    }
}
