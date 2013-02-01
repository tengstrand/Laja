package net.sf.laja.cdd.behaviour.animal;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;
import java.util.ArrayList;

public class AnimalFactory extends AnimalBehaviour {

    public AnimalFactory(AnimalState state) {
        super(state);
    }

    public AnimalFactory(AnimalState state, AnimalStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static AnimalEncapsulator isTerrestrial(boolean isTerrestrial) {
        return new AnimalCreator().new IsTerrestrial_().isTerrestrial(isTerrestrial);
    }

    public static AnimalBuilder build() {
        return new AnimalBuilder();
    }

    public static AnimalSetEncapsulator createSet(AnimalEncapsulator... encapsulators) {
        return new AnimalSetEncapsulator(encapsulators);
    }

    public static AnimalListEncapsulator createList(AnimalEncapsulator... encapsulators) {
        return new AnimalListEncapsulator(encapsulators);
    }

    public static class AnimalFactory_ implements AnimalBehaviourFactory {
        private final AnimalStateBuilder stateBuilder;

        public AnimalFactory_(AnimalStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(AnimalState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Animal'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(AnimalState state, Object... args) {
        return new Animal(state);
    
      }
    }
}
