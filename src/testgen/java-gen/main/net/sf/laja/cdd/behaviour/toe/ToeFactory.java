package net.sf.laja.cdd.behaviour.toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeFactory extends ToeBehaviour {

    public ToeFactory(ToeState state) {
        super(state);
    }

    public static ToeCreator.Weight_ length(int length) {
        return new ToeCreator().new Length_().length(length);
    }

    public static ToeBuilder build() {
        return new ToeBuilder();
    }

    public static ToeSetEncapsulator createSet(ToeEncapsulator... encapsulators) {
        return new ToeSetEncapsulator(encapsulators);
    }

    public static ToeListEncapsulator createList(ToeEncapsulator... encapsulators) {
        return new ToeListEncapsulator(encapsulators);
    }

    public static class ToeFactory_ implements ToeBehaviourFactory {

        public Object create(ToeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Toe'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ToeState state, Object... args) {
        return new Toe(state);
    
      }
    }
}
