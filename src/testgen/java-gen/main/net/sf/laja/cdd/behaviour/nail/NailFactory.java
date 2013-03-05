package net.sf.laja.cdd.behaviour.nail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.nail.*;
import net.sf.laja.cdd.state.nail.NailState;

public class NailFactory extends NailBehaviour {

    public NailFactory(NailState state) {
        super(state);
    }

    public static NailEncapsulator color(String color) {
        return new NailCreator().new Color_().color(color);
    }

    public static NailBuilder build() {
        return new NailBuilder();
    }

    public static NailSetEncapsulator createSet(NailEncapsulator... encapsulators) {
        return new NailSetEncapsulator(encapsulators);
    }

    public static NailListEncapsulator createList(NailEncapsulator... encapsulators) {
        return new NailListEncapsulator(encapsulators);
    }

    public static class NailFactory_ implements NailBehaviourFactory {

        public Object create(NailState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Nail'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(NailState state, Object... args) {
        return new Nail(state);
    
      }
    }
}
