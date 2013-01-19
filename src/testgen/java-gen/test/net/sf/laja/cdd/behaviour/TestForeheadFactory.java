package net.sf.laja.cdd.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.*;
import java.util.Arrays;
import net.sf.laja.cdd.state.brow.BrowStateList;
import java.util.ArrayList;

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
