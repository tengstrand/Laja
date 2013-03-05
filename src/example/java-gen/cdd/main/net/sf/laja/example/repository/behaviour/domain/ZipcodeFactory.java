package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.ZipcodeState;
import java.util.Arrays;
import java.util.ArrayList;

public class ZipcodeFactory extends ZipcodeBehaviour {

    public ZipcodeFactory(ZipcodeState state) {
        super(state);
    }

    public static ZipcodeEncapsulator zipcode(int zipcode) {
        return new ZipcodeCreator().new Zipcode_().zipcode(zipcode);
    }

    public static ZipcodeBuilder build() {
        return new ZipcodeBuilder();
    }

    public static ZipcodeSetEncapsulator createSet(ZipcodeEncapsulator... encapsulators) {
        return new ZipcodeSetEncapsulator(encapsulators);
    }

    public static ZipcodeListEncapsulator createList(ZipcodeEncapsulator... encapsulators) {
        return new ZipcodeListEncapsulator(encapsulators);
    }

    public static class ZipcodeFactory_ implements ZipcodeBehaviourFactory {
        private final ZipcodeStateBuilder stateBuilder;

        public ZipcodeFactory_(ZipcodeStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(ZipcodeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Zipcode'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ZipcodeState state, Object... args) {
        return new Zipcode(state);
    
      }
    }
}
