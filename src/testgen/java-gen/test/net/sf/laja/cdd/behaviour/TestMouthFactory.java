package net.sf.laja.cdd.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouthFactory extends MouthBehaviour {

    public TestMouthFactory(MouthState state) {
        super(state);
    }

    public static TestMouthCreator.Height_ width(int width) {
        return new TestMouthCreator().new Width_().width(width);
    }

    public static TestMouthBuilder build() {
        return new TestMouthBuilder();
    }

    public static TestMouthSetEncapsulator createSet(TestMouthEncapsulator... encapsulators) {
        return new TestMouthSetEncapsulator(encapsulators);
    }

    public static TestMouthListEncapsulator createList(TestMouthEncapsulator... encapsulators) {
        return new TestMouthListEncapsulator(encapsulators);
    }

    public static class TestMouthFactory_ implements MouthBehaviourFactory {

        public Object create(MouthState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TestMouth'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(MouthState state, Object... args) {
        return new TestMouth(state);
    
      }
    }
}
