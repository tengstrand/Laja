package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouthBuilder {
    public final MouthStateBuilder builder;

    public TestMouthBuilder() {
        builder = MouthStateImpl.build();
    }

    public TestMouthBuilder(MouthState state) {
        builder = MouthStateImpl.build(state);
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
