package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;
import net.sf.laja.cdd.state.mouth.MouthStateBuilderImpl;
import net.sf.laja.cdd.state.mouth.MouthStateImpl;

public class TestMouthBuilder {
    public final MouthStateBuilder builder;

    public TestMouthBuilder() {
        builder = MouthStateImpl.build();
    }

    public TestMouthBuilder(MouthState state) {
        builder = new MouthStateBuilderImpl(state);
    }

    public TestMouthBuilder(MouthState state, Object encapsulator) {
        builder = new MouthStateBuilderImpl(state, encapsulator);
    }

    public TestMouthBuilder withNumberOfTeeth(int numberOfTeeth) {
        builder.withNumberOfTeeth(numberOfTeeth);
        return this;
    }

    public TestMouthBuilder withWidth(int width) {
        builder.withWidth(width);
        return this;
    }

    public TestMouthBuilder withHeight(int height) {
        builder.withHeight(height);
        return this;
    }

    public TestMouthBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestMouth asTestMouth() {
        return (TestMouth)builder.as(new TestMouthFactory.TestMouthFactory_(builder));
    }
}
