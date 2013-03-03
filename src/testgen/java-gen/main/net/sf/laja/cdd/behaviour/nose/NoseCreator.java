package net.sf.laja.cdd.behaviour.nose;
import net.sf.laja.cdd.state.nose.*;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseCreator {
    private final NoseStateBuilder builder = NoseStateImpl.build();

    public class NoseDescription_ {
        public Details_ noseDescription(String noseDescription) {
            builder.withNoseDescription(noseDescription);
            return new Details_();
        }
    }

    public class Details_ {
        public NoseEncapsulator details(String details) {
            builder.withDetails(details);
            return create();
        }
    }

    public NoseEncapsulator create() {
        return new NoseEncapsulator(builder);
     }
}
