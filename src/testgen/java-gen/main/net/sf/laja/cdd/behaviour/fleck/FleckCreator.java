package net.sf.laja.cdd.behaviour.fleck;
import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckCreator {
    private final FleckStateBuilder builder = FleckStateImpl.build();

    public FleckEncapsulator create() {
        return new FleckEncapsulator(builder);
     }
}
