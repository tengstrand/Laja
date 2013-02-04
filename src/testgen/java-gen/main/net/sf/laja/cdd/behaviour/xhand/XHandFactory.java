package net.sf.laja.cdd.behaviour.xhand;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;

public class XHandFactory extends XHandBehaviour {

    public XHandFactory(XHandState state) {
        super(state);
    }

    public XHandFactory(XHandState state, XHandStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static XHandEncapsulator color(String color) {
        return new XHandCreator().new Color_().color(color);
    }

    public static XHandBuilder build() {
        return new XHandBuilder();
    }

    public static XHandSetEncapsulator createSet(XHandEncapsulator... encapsulators) {
        return new XHandSetEncapsulator(encapsulators);
    }

    public static XHandListEncapsulator createList(XHandEncapsulator... encapsulators) {
        return new XHandListEncapsulator(encapsulators);
    }

    public static class XHandFactory_ implements XHandBehaviourFactory {
        private final XHandStateBuilder stateBuilder;

        public XHandFactory_(XHandStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(XHandState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'XHand'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(XHandState state, Object... args) {
        return new XHand(state);
    
      }
    }
}
