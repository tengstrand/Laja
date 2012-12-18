package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.HeightState;
import net.sf.laja.example.person.state.HeightStateBuilder;
import net.sf.laja.example.person.state.HeightStateBuilderImpl;
import net.sf.laja.example.person.state.HeightStateImpl;

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
