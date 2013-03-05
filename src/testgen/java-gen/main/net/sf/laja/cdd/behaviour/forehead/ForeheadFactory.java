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

public class ForeheadFactory extends ForeheadBehaviour {

    public ForeheadFactory(ForeheadState state) {
        super(state);
    }

    public static ForeheadEncapsulator create() {
        return new ForeheadCreator().create();
    }

    public static ForeheadBuilder build() {
        return new ForeheadBuilder();
    }

    public static ForeheadSetEncapsulator createSet(ForeheadEncapsulator... encapsulators) {
        return new ForeheadSetEncapsulator(encapsulators);
    }

    public static ForeheadListEncapsulator createList(ForeheadEncapsulator... encapsulators) {
        return new ForeheadListEncapsulator(encapsulators);
    }

    public static class ForeheadFactory_ implements ForeheadBehaviourFactory {
        private final ForeheadStateBuilder stateBuilder;

        public ForeheadFactory_(ForeheadStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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

    public static class ForeheadWithBigBrowsFactory_ implements ForeheadBehaviourFactory {
        private final ForeheadStateBuilder stateBuilder;

        public ForeheadWithBigBrowsFactory_(ForeheadStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
