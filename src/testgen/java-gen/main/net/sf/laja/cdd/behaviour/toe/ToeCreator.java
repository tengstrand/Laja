package net.sf.laja.cdd.behaviour.toe;
import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeCreator {
    private final ToeStateBuilder builder = ToeStateImpl.build();

    public class Length_ {
        public Weight_ length(int length) {
            builder.withLength(length);
            return new Weight_();
        }
    }

    public class Weight_ {
        public ToeEncapsulator weight(int weight) {
            builder.withWeight(weight);
            return create();
        }
    }

    public ToeEncapsulator create() {
        return new ToeEncapsulator(builder);
     }
}
