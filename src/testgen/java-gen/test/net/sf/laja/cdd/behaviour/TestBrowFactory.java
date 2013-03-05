package net.sf.laja.cdd.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowFactory extends BrowBehaviour {

    public TestBrowFactory(BrowState state) {
        super(state);
    }

    public static TestBrowEncapsulator area(int area) {
        return new TestBrowCreator().new Area_().area(area);
    }

    public static TestBrowBuilder build() {
        return new TestBrowBuilder();
    }

    public static TestBrowSetEncapsulator createSet(TestBrowEncapsulator... encapsulators) {
        return new TestBrowSetEncapsulator(encapsulators);
    }

    public static TestBrowListEncapsulator createList(TestBrowEncapsulator... encapsulators) {
        return new TestBrowListEncapsulator(encapsulators);
    }

    public static class TestBrowFactory_ implements BrowBehaviourFactory {

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
