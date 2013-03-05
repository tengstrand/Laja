package net.sf.laja.example.computer.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.computer.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariFactory extends ComputerBehaviour {

    public AtariFactory(ComputerState state) {
        super(state);
    }

    public static AtariEncapsulator owner(String owner) {
        return new AtariCreator().new Owner_().owner(owner);
    }

    public static AtariBuilder build() {
        return new AtariBuilder();
    }

    public static AtariSetEncapsulator createSet(AtariEncapsulator... encapsulators) {
        return new AtariSetEncapsulator(encapsulators);
    }

    public static AtariListEncapsulator createList(AtariEncapsulator... encapsulators) {
        return new AtariListEncapsulator(encapsulators);
    }

    public static class AtariSTFactory_ implements ComputerBehaviourFactory {

        public Object create(ComputerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'AtariST'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ComputerState state, Object... args) {
        return new AtariST(state);
    
      }
    }

    public static class AtariFalcon030Factory_ implements ComputerBehaviourFactory {

        public Object create(ComputerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'AtariFalcon030'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ComputerState state, Object... args) {
        return new AtariFalcon030(state);
    
      }
    }
}
