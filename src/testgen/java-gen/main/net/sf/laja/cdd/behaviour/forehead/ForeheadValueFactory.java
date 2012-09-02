package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowList;

public class ForeheadValueFactory extends ForeheadValue {

    public ForeheadValueFactory(ForeheadState state) {
        super(state);
    }

    public ForeheadValueFactory(ForeheadState state, ForeheadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static ForeheadEncapsulator create() {
        return new ForeheadCreator().create();
    }

    public static ForeheadBuilder build() {
        return new ForeheadBuilder();
    }

    public static class ForeheadFactory_ implements ForeheadStateBehaviourFactory {
        private final ForeheadStateBuilder builder;

        public ForeheadFactory_(ForeheadStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(ForeheadState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Forehead'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ForeheadState state, Object... args) {
        return new Forehead(state);
    
      }
    }
}
