package net.sf.laja.cdd.behaviour.hair;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.hair.*;
import java.util.ArrayList;
import net.sf.laja.cdd.state.hair.HairState;

public class HairFactory extends HairBehaviour {

    public HairFactory(HairState state) {
        super(state);
    }

    public static HairCreator.Color_ length(int length) {
        return new HairCreator().new Length_().length(length);
    }

    public static HairBuilder build() {
        return new HairBuilder();
    }

    public static HairSetEncapsulator createSet(HairEncapsulator... encapsulators) {
        return new HairSetEncapsulator(encapsulators);
    }

    public static HairListEncapsulator createList(HairEncapsulator... encapsulators) {
        return new HairListEncapsulator(encapsulators);
    }

    public static class HairFactory_ implements HairBehaviourFactory {

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

    public static class FakeHairFactory_ implements HairBehaviourFactory {

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
