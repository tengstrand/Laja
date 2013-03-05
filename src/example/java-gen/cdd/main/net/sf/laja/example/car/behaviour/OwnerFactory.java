package net.sf.laja.example.car.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerFactory extends OwnerBehaviour {

    public OwnerFactory(OwnerState state) {
        super(state);
    }

    public static OwnerCreator.Name_ ssn(long ssn) {
        return new OwnerCreator().new Ssn_().ssn(ssn);
    }

    public static OwnerBuilder build() {
        return new OwnerBuilder();
    }

    public static OwnerSetEncapsulator createSet(OwnerEncapsulator... encapsulators) {
        return new OwnerSetEncapsulator(encapsulators);
    }

    public static OwnerListEncapsulator createList(OwnerEncapsulator... encapsulators) {
        return new OwnerListEncapsulator(encapsulators);
    }

    public static class OwnerFactory_ implements OwnerBehaviourFactory {

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
