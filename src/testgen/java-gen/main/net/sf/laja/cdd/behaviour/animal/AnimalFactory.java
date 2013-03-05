package net.sf.laja.cdd.behaviour.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalFactory extends AnimalBehaviour {

    public AnimalFactory(AnimalState state) {
        super(state);
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
