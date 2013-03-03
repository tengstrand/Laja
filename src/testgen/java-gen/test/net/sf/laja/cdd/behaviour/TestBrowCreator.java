package net.sf.laja.cdd.behaviour;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowCreator {
    private final BrowStateBuilder builder = BrowStateImpl.build();

    public class Area_ {
        public TestBrowEncapsulator area(int area) {
            builder.withArea(area);
            return create();
        }
    }

    public TestBrowEncapsulator create() {
        return new TestBrowEncapsulator(builder);
     }
}
