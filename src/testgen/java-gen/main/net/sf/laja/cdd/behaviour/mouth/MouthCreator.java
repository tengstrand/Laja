package net.sf.laja.cdd.behaviour.mouth;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthCreator {
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
        public MouthEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public MouthEncapsulator create() {
        return new MouthEncapsulator(builder);
     }
}
