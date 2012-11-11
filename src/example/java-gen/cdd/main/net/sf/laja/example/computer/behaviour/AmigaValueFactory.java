package net.sf.laja.example.computer.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.computer.state.*;
import java.util.Arrays;
import java.util.ArrayList;

public class AmigaValueFactory extends ComputerValue {

    public AmigaValueFactory(ComputerState state) {
        super(state);
    }

    public AmigaValueFactory(ComputerState state, ComputerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

  // 1
    public static AmigaEncapsulator owner(String owner) {
        return new AmigaCreator().new Owner_().owner(owner);
    }

    public static AmigaBuilder build() {
        return new AmigaBuilder();
    }

    public static AmigaListCreator createList(AmigaEncapsulator... encapsulators) {
        return new AmigaListCreator(encapsulators);
    }

    public static class AmigaFactory_ implements ComputerStateBehaviourFactory {
        private final ComputerStateBuilder builder;

        public AmigaFactory_(ComputerStateBuilder builder) {
            this.builder = builder;
        }

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
