package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;
// Toe

public class HairEncapsulator implements HairStateComparable {
    public final HairStateBuilder builder;

    public HairEncapsulator(HairStateBuilder builder) {
        this.builder = builder;
    }

    public Hair asHair() {
        return (Hair)builder.as(new HairFactory.HairFactory_());
    }

    public FakeHair asFakeHair() {
        return (FakeHair)builder.as(new HairFactory.FakeHairFactory_());
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
