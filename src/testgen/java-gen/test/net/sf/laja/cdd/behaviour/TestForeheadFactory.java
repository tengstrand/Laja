package net.sf.laja.cdd.behaviour;

import java.util.List;
import net.sf.laja.cdd.state.forehead.*;
import java.util.Arrays;
import net.sf.laja.cdd.behaviour.ear.Ear;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;
import net.sf.laja.cdd.behaviour.ear.EarSet;
import java.util.ArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import java.util.Iterator;
import java.util.Set;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import java.util.HashSet;
import net.sf.laja.cdd.behaviour.brow.BrowList;

public class TestForeheadFactory extends ForeheadBehaviour {

    public TestForeheadFactory(ForeheadState state) {
        super(state);
    }

    public TestForeheadFactory(ForeheadState state, ForeheadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestForeheadEncapsulator create() {
        return new TestForeheadCreator().create();
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
        private final ForeheadStateBuilder stateBuilder;

        public TestForeheadFactory_(ForeheadStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
