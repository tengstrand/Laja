package net.sf.laja.cdd.behaviour.leg;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.leg.*;
import java.util.ArrayList;
import net.sf.laja.cdd.state.leg.LegState;

public class LegValueFactory extends LegValue {

    public LegValueFactory(LegState state) {
        super(state);
    }

    public LegValueFactory(LegState state, LegStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static LegEncapsulator legDescription(String legDescription) {
        return new LegCreator().new LegDescription_().legDescription(legDescription);
    }

    public static LegBuilder build() {
        return new LegBuilder();
    }

    public static LegListEncapsulator createList(LegEncapsulator... encapsulators) {
        return new LegListEncapsulator(encapsulators);
    }

    public static class LegFactory_ implements LegStateBehaviourFactory {
        private final LegStateBuilder stateBuilder;

        public LegFactory_(LegStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
