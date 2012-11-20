package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.MouthStateBuilder;
import net.sf.laja.cdd.state.mouth.MouthStateImpl;

public class TestMouthCreator {
    private final MouthStateBuilder builder = MouthStateImpl.build();

    public class Width_ {
        public Height_ width(int width) {
            builder.withWidth(width);
            return new Height_();
        }
    }

    public class Height_ {
        public Color_ height(int height) {
            builder.withHeight(height);
            return new Color_();
        }
    }

    public class Color_ {
        public TestMouthEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public TestMouthEncapsulator create() {
        return new TestMouthEncapsulator(builder);
     }
}
