package net.sf.laja.cdd.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.brow.BrowState;
import java.util.Arrays;
import net.sf.laja.cdd.state.brow.*;
import java.util.ArrayList;

public class TestBrowFactory extends BrowBehaviour {

    public TestBrowFactory(BrowState state) {
        super(state);
    }

    public TestBrowFactory(BrowState state, BrowStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestBrowEncapsulator area(int area) {
        return new TestBrowCreator().new Area_().area(area);
    }

    public static TestBrowBuilder build() {
        return new TestBrowBuilder();
    }

    public static TestBrowListEncapsulator createList(TestBrowEncapsulator... encapsulators) {
        return new TestBrowListEncapsulator(encapsulators);
    }

    public static class TestBrowFactory_ implements BrowBehaviourFactory {
        private final BrowStateBuilder stateBuilder;

        public TestBrowFactory_(BrowStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(BrowState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TestBrow'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BrowState state, Object... args) {
        return new TestBrow(state);
    
      }
    }
}
