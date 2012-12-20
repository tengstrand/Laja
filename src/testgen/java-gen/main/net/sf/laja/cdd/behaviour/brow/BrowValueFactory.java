package net.sf.laja.cdd.behaviour.brow;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.brow.BrowState;
import java.util.Arrays;
import net.sf.laja.cdd.state.brow.*;
import java.util.ArrayList;

public class BrowValueFactory extends BrowValue {

    public BrowValueFactory(BrowState state) {
        super(state);
    }

    public BrowValueFactory(BrowState state, BrowStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static BrowEncapsulator area(int area) {
        return new BrowCreator().new Area_().area(area);
    }

    public static BrowBuilder build() {
        return new BrowBuilder();
    }

    public static BrowListEncapsulator createList(BrowEncapsulator... encapsulators) {
        return new BrowListEncapsulator(encapsulators);
    }

    public static class BrowFactory_ implements BrowStateBehaviourFactory {
        private final BrowStateBuilder builder;

        public BrowFactory_(BrowStateBuilder builder) {
            this.builder = builder;
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

    public static class BigBrowFactory_ implements BrowStateBehaviourFactory {
        private final BrowStateBuilder builder;

        public BigBrowFactory_(BrowStateBuilder builder) {
            this.builder = builder;
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
