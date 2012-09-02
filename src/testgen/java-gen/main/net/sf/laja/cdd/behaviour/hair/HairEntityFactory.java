package net.sf.laja.cdd.behaviour.hair;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.hair.*;
import java.util.ArrayList;
import net.sf.laja.cdd.state.hair.HairState;

public class HairEntityFactory extends HairEntity {

    public HairEntityFactory(HairState state) {
        super(state);
    }

    public HairEntityFactory(HairState state, HairStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static HairCreator.Color_ length(int length) {
        return new HairCreator().new Length_().length(length);
    }

    public static HairBuilder build() {
        return new HairBuilder();
    }

    public static HairListCreator createList(HairEncapsulator... encapsulators) {
        return new HairListCreator(encapsulators);
    }

    public static class HairFactory_ implements HairStateBehaviourFactory {
        private final HairStateBuilder builder;

        public HairFactory_(HairStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(HairState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Hair'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HairState state, Object... args) {
        return new Hair(state);
    
      }
    }

    public static class FakeHairFactory_ implements HairStateBehaviourFactory {
        private final HairStateBuilder builder;

        public FakeHairFactory_(HairStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(HairState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'FakeHair'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HairState state, Object... args) {
        return new FakeHair(state);
    
      }
    }
}
