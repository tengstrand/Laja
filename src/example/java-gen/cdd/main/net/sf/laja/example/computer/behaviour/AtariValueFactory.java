package net.sf.laja.example.computer.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.computer.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.computer.state.ComputerState;

public class AtariValueFactory extends ComputerValue {

    public AtariValueFactory(ComputerState state) {
        super(state);
    }

    public AtariValueFactory(ComputerState state, ComputerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static AtariEncapsulator owner(String owner) {
        return new AtariCreator().new Owner_().owner(owner);
    }

    public static AtariBuilder build() {
        return new AtariBuilder();
    }

    public static AtariListCreator createList(AtariEncapsulator... encapsulators) {
        return new AtariListCreator(encapsulators);
    }

    public static class AtariSTFactory_ implements ComputerStateBehaviourFactory {
        private final ComputerStateBuilder builder;

        public AtariSTFactory_(ComputerStateBuilder builder) {
            this.builder = builder;
        }

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

    public static class AtariFalcon030Factory_ implements ComputerStateBehaviourFactory {
        private final ComputerStateBuilder builder;

        public AtariFalcon030Factory_(ComputerStateBuilder builder) {
            this.builder = builder;
        }

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
