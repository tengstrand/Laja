package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;

public class HairBuilder {
    public final HairStateBuilder builder;

    public HairBuilder() {
        builder = HairStateImpl.build();
    }

    public HairBuilder(HairState state) {
        builder = HairStateImpl.build(state);
    }

    public HairBuilder withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public HairBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Hair asHair() {
        return (Hair)builder.as(new HairFactory.HairFactory_(builder));
    }

    public FakeHair asFakeHair() {
        return (FakeHair)builder.as(new HairFactory.FakeHairFactory_(builder));
    }
}
