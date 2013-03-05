package net.sf.laja.cdd.behaviour.nail;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.nail.NailState;
import net.sf.laja.cdd.state.nail.*;
import java.util.Arrays;
import java.util.ArrayList;

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
        private final NailStateBuilder stateBuilder;

        public NailFactory_(NailStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
