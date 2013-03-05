package net.sf.laja.cdd.behaviour.leg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegFactory extends LegBehaviour {

    public LegFactory(LegState state) {
        super(state);
    }

    public static LegEncapsulator legDescription(String legDescription) {
        return new LegCreator().new LegDescription_().legDescription(legDescription);
    }

    public static LegBuilder build() {
        return new LegBuilder();
    }

    public static LegSetEncapsulator createSet(LegEncapsulator... encapsulators) {
        return new LegSetEncapsulator(encapsulators);
    }

    public static LegListEncapsulator createList(LegEncapsulator... encapsulators) {
        return new LegListEncapsulator(encapsulators);
    }

    public static class LegFactory_ implements LegBehaviourFactory {

        public Object create(LegState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Leg'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(LegState state, Object... args) {
        return new Leg(state);
    
      }
    }
}
