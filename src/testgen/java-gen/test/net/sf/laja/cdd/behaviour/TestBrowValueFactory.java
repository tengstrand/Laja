package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateBehaviourFactory;
import net.sf.laja.cdd.state.brow.BrowStateBuilder;
import net.sf.laja.cdd.state.brow.BrowValue;

public class TestBrowValueFactory extends BrowValue {

    public TestBrowValueFactory(BrowState state) {
        super(state);
    }

    public TestBrowValueFactory(BrowState state, BrowStateBuilder stateBuilder) {
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

    public static class TestBrowFactory_ implements BrowStateBehaviourFactory {
        private final BrowStateBuilder builder;

        public TestBrowFactory_(BrowStateBuilder builder) {
            this.builder = builder;
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
