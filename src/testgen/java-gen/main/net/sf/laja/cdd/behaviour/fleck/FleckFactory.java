package net.sf.laja.cdd.behaviour.fleck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.fleck.*;
import net.sf.laja.cdd.state.fleck.FleckState;

public class FleckFactory extends FleckBehaviour {

    public FleckFactory(FleckState state) {
        super(state);
    }

    public static FleckEncapsulator create() {
        return new FleckCreator().create();
    }

    public static FleckBuilder build() {
        return new FleckBuilder();
    }

    public static FleckSetEncapsulator createSet(FleckEncapsulator... encapsulators) {
        return new FleckSetEncapsulator(encapsulators);
    }

    public static FleckListEncapsulator createList(FleckEncapsulator... encapsulators) {
        return new FleckListEncapsulator(encapsulators);
    }

    public static class FleckFactory_ implements FleckBehaviourFactory {

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
