package net.sf.laja.example.computer.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.computer.state.*;
import java.util.Arrays;
import java.util.ArrayList;

public class AmigaFactory extends ComputerBehaviour {

    public AmigaFactory(ComputerState state) {
        super(state);
    }

    public static AmigaEncapsulator owner(String owner) {
        return new AmigaCreator().new Owner_().owner(owner);
    }

    public static AmigaBuilder build() {
        return new AmigaBuilder();
    }

    public static AmigaSetEncapsulator createSet(AmigaEncapsulator... encapsulators) {
        return new AmigaSetEncapsulator(encapsulators);
    }

    public static AmigaListEncapsulator createList(AmigaEncapsulator... encapsulators) {
        return new AmigaListEncapsulator(encapsulators);
    }

    public static class AmigaFactory_ implements ComputerBehaviourFactory {

        public Object create(ComputerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Amiga'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ComputerState state, Object... args) {
        Configuration context = (Configuration)args[0];

        if (context == Configuration.FAST) {
            return new Amiga4000(state);
        }
        return new Amiga500(state);
    
      }
    }
}
