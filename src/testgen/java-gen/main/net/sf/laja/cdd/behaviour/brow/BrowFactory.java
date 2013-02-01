package net.sf.laja.cdd.behaviour.brow;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.brow.BrowState;
import java.util.Arrays;
import net.sf.laja.cdd.state.brow.*;
import java.util.ArrayList;

public class BrowFactory extends BrowBehaviour {

    public BrowFactory(BrowState state) {
        super(state);
    }

    public BrowFactory(BrowState state, BrowStateBuilder stateBuilder) {
        super(state, stateBuilder);
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
        private final BrowStateBuilder stateBuilder;

        public BrowFactory_(BrowStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
        private final BrowStateBuilder stateBuilder;

        public BigBrowFactory_(BrowStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
