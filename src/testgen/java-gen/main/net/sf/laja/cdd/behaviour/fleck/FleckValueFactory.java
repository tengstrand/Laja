package net.sf.laja.cdd.behaviour.fleck;

import net.sf.laja.cdd.state.fleck.FleckState;
import net.sf.laja.cdd.state.fleck.FleckStateBehaviourFactory;
import net.sf.laja.cdd.state.fleck.FleckStateBuilder;
import net.sf.laja.cdd.state.fleck.FleckValue;

public class FleckValueFactory extends FleckValue {

    public FleckValueFactory(FleckState state) {
        super(state);
    }

    public FleckValueFactory(FleckState state, FleckStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static FleckEncapsulator create() {
        return new FleckCreator().create();
    }

    public static FleckBuilder build() {
        return new FleckBuilder();
    }

    public static FleckListEncapsulator createList(FleckEncapsulator... encapsulators) {
        return new FleckListEncapsulator(encapsulators);
    }

    public static class FleckFactory_ implements FleckStateBehaviourFactory {
        private final FleckStateBuilder builder;

        public FleckFactory_(FleckStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(FleckState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Fleck'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(FleckState state, Object... args) {
        return new Fleck(state);
    
      }
    }
}
