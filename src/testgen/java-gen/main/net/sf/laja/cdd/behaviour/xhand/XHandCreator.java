package net.sf.laja.cdd.behaviour.xhand;

import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;
import net.sf.laja.cdd.state.finger.FingerState;

public class XHandCreator {
    private final XHandStateBuilder builder = XHandStateImpl.build();

    public class Color_ {
        public XHandEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public XHandEncapsulator create() {
        return new XHandEncapsulator(builder);
     }
}
