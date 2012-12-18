package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightBuilder {
    public final HeightStateBuilder builder;

    public HeightBuilder() {
        builder = HeightStateImpl.build();
    }

    public HeightBuilder(HeightState state) {
        builder = new HeightStateBuilderImpl(state);
    }

    public HeightBuilder(HeightState state, Object encapsulator) {
        builder = new HeightStateBuilderImpl(state, encapsulator);
    }

    public HeightBuilder withHeightInCentimeters(int heightInCentimeters) {
        builder.withHeightInCentimeters(heightInCentimeters);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Height asHeight() {
        return (Height)builder.as(new HeightFactory.HeightFactory_(builder));
    }
}
