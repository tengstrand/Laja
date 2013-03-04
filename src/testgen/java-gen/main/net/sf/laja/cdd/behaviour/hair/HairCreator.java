package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.*;
import net.sf.laja.cdd.state.hair.HairState;

public class HairCreator {
    private final HairStateBuilder builder = HairStateImpl.build();

    public class Length_ {
        public Color_ length(int length) {
            builder.withLength(length);
            return new Color_();
        }
    }

    public class Color_ {
        public HairEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public HairEncapsulator create() {
        return new HairEncapsulator(builder);
     }
}
