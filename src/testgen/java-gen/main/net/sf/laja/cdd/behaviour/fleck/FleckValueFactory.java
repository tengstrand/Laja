package net.sf.laja.cdd.behaviour.fleck;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.fleck.FleckState;
import java.util.Arrays;
import net.sf.laja.cdd.state.fleck.*;
import java.util.ArrayList;

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

    public static FleckListCreator createList(FleckEncapsulator... encapsulators) {
        return new FleckListCreator(encapsulators);
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
