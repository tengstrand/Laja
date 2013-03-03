package net.sf.laja.cdd.behaviour.nail;
import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;

public class NailCreator {
    private final NailStateBuilder builder = NailStateImpl.build();

    public class Color_ {
        public NailEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public NailEncapsulator create() {
        return new NailEncapsulator(builder);
     }
}
