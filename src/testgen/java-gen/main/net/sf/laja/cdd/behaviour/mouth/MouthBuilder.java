package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthBuilder {
    public final MouthStateBuilder builder;

    public MouthBuilder() {
        builder = MouthStateImpl.build();
    }

    public MouthBuilder(MouthState state) {
        builder = MouthStateImpl.build(state);
    }

    public MouthBuilder withWidth(int width) {
        builder.withWidth(width);
        return this;
    }

    public MouthBuilder withHeight(int height) {
        builder.withHeight(height);
        return this;
    }

    public MouthBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Mouth asMouth(MouthSize size) {
        return (Mouth)builder.as(new MouthFactory.MouthFactory_(builder), size);
    }
}
