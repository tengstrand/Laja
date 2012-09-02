package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowCreator {
    private final BrowStateBuilder builder = BrowStateImpl.build();

    public class Area_ {
        public BrowEncapsulator area(int area) {
            builder.withArea(area);
            return create();
        }
    }

    public BrowEncapsulator create() {
        return new BrowEncapsulator(builder);
     }
}
