package net.sf.laja.cdd.behaviour.brow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowFactory extends BrowBehaviour {

    public BrowFactory(BrowState state) {
        super(state);
    }

    public static BrowEncapsulator area(int area) {
        return new BrowCreator().new Area_().area(area);
    }

    public static BrowBuilder build() {
        return new BrowBuilder();
    }

    public static BrowSetEncapsulator createSet(BrowEncapsulator... encapsulators) {
        return new BrowSetEncapsulator(encapsulators);
    }

    public static BrowListEncapsulator createList(BrowEncapsulator... encapsulators) {
        return new BrowListEncapsulator(encapsulators);
    }

    public static class BrowFactory_ implements BrowBehaviourFactory {

        public Object create(BrowState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Brow'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BrowState state, Object... args) {
        return new Brow(state);
    
      }
    }

    public static class BigBrowFactory_ implements BrowBehaviourFactory {

        public Object create(BrowState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'BigBrow'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BrowState state, Object... args) {
        return new BigBrow(state);
    
      }
    }
}
