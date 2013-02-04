package net.sf.laja.cdd.behaviour.finger;

import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;

public class FingerCreator {
    private final FingerStateBuilder builder = FingerStateImpl.build();

    public class Color_ {
        public FingerEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public FingerEncapsulator create() {
        return new FingerEncapsulator(builder);
     }
}
