package net.sf.laja.cdd.behaviour.forehead;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.*;
import java.util.Arrays;
import net.sf.laja.cdd.behaviour.brow.Brow;
import java.util.ArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
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

    public static ForeheadListEncapsulator createList(ForeheadEncapsulator... encapsulators) {
        return new ForeheadListEncapsulator(encapsulators);
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

    public static class ForeheadWithBigBrowsFactory_ implements ForeheadStateBehaviourFactory {
        private final ForeheadStateBuilder builder;

        public ForeheadWithBigBrowsFactory_(ForeheadStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(ForeheadState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'ForeheadWithBigBrows'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ForeheadState state, Object... args) {
        return new ForeheadWithBigBrows(state);
    
      }
    }
}
