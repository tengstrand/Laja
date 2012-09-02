package net.sf.laja.cdd.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.mouth.MouthState;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.*;

public class TestMouthValueFactory extends MouthValue {

    public TestMouthValueFactory(MouthState state) {
        super(state);
    }

    public TestMouthValueFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestMouthCreator.Height_ width(int width) {
        return new TestMouthCreator().new Width_().width(width);
    }

    public static TestMouthBuilder build() {
        return new TestMouthBuilder();
    }

    public static TestMouthListCreator createList(TestMouthEncapsulator... encapsulators) {
        return new TestMouthListCreator(encapsulators);
    }

    public static class TestMouthFactory_ implements MouthStateBehaviourFactory {
        private final MouthStateBuilder builder;

        public TestMouthFactory_(MouthStateBuilder builder) {
            this.builder = builder;
        }

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
