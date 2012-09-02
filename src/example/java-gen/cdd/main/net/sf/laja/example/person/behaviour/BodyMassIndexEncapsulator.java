package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndexEncapsulator {
    public final BmiStateBuilder builder;

    public BodyMassIndexEncapsulator(BmiStateBuilder builder) {
        this.builder = builder;
    }

    public BodyMassIndex asBodyMassIndex() {
        return (BodyMassIndex)builder.as(new BodyMassIndexFactory.BodyMassIndexFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
