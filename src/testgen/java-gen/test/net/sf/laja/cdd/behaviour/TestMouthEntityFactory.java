package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.MouthEntity;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBehaviourFactory;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class TestMouthEntityFactory extends MouthEntity {

    public TestMouthEntityFactory(MouthState state) {
        super(state);
    }

    public TestMouthEntityFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestMouthCreator.Height_ width(int width) {
        return new TestMouthCreator().new Width_().width(width);
    }

    public static TestMouthBuilder build() {
        return new TestMouthBuilder();
    }

    public static TestMouthListEncapsulator createList(TestMouthEncapsulator... encapsulators) {
        return new TestMouthListEncapsulator(encapsulators);
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
