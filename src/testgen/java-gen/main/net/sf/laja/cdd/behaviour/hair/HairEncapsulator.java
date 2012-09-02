package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;

public class HairEncapsulator {
    public final HairStateBuilder builder;

    public HairEncapsulator(HairStateBuilder builder) {
        this.builder = builder;
    }

    public Hair asHair() {
        return (Hair)builder.as(new HairFactory.HairFactory_(builder));
    }

    public FakeHair asFakeHair() {
        return (FakeHair)builder.as(new HairFactory.FakeHairFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
