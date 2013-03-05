package net.sf.laja.cdd.behaviour.forehead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.forehead.ForeheadState;

public class ForeheadFactory extends ForeheadBehaviour {

    public ForeheadFactory(ForeheadState state) {
        super(state);
    }

    public static ForeheadEncapsulator brow(BrowEncapsulator brow) {
        return new ForeheadCreator().new Brow_().brow(brow);
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
