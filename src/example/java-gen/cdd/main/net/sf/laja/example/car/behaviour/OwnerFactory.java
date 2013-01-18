package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerFactory extends OwnerBehaviour {

    public OwnerFactory(OwnerState state) {
        super(state);
    }

    public OwnerFactory(OwnerState state, OwnerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static OwnerCreator.Name_ ssn(long ssn) {
        return new OwnerCreator().new Ssn_().ssn(ssn);
    }

    public static OwnerBuilder build() {
        return new OwnerBuilder();
    }

    public static OwnerListEncapsulator createList(OwnerEncapsulator... encapsulators) {
        return new OwnerListEncapsulator(encapsulators);
    }

    public static class OwnerFactory_ implements OwnerStateBehaviourFactory {
        private final OwnerStateBuilder stateBuilder;

        public OwnerFactory_(OwnerStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(OwnerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Owner'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(OwnerState state, Object... args) {
        return new Owner(state);
    
      }
    }
}
