package net.sf.laja.cdd.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEar;
import net.sf.laja.cdd.behaviour.ear.TheEarHashSet;
import net.sf.laja.cdd.behaviour.ear.TheEarSet;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.forehead.ForeheadState;

public class TestForeheadFactory extends ForeheadBehaviour {

    public TestForeheadFactory(ForeheadState state) {
        super(state);
    }

    public static TestForeheadEncapsulator brow(BrowEncapsulator brow) {
        return new TestForeheadCreator().new Brow_().brow(brow);
    }

    public static TestForeheadBuilder build() {
        return new TestForeheadBuilder();
    }

    public static TestForeheadSetEncapsulator createSet(TestForeheadEncapsulator... encapsulators) {
        return new TestForeheadSetEncapsulator(encapsulators);
    }

    public static TestForeheadListEncapsulator createList(TestForeheadEncapsulator... encapsulators) {
        return new TestForeheadListEncapsulator(encapsulators);
    }

    public static class TestForeheadFactory_ implements ForeheadBehaviourFactory {

        public Object create(ForeheadState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TestForehead'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ForeheadState state, Object... args) {
        return new TestForehead(state);
    
      }
    }
}
