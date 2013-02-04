package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;
// Person

public class BodyMassIndexEncapsulator implements BmiStateComparable {
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
