package net.sf.laja.cdd.behaviour.hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandFactory extends HandBehaviour {

    public HandFactory(HandState state) {
        super(state);
    }

    public static HandEncapsulator area(int area) {
        return new HandCreator().new Area_().area(area);
    }

    public static HandBuilder build() {
        return new HandBuilder();
    }

    public static HandSetEncapsulator createSet(HandEncapsulator... encapsulators) {
        return new HandSetEncapsulator(encapsulators);
    }

    public static HandListEncapsulator createList(HandEncapsulator... encapsulators) {
        return new HandListEncapsulator(encapsulators);
    }

    public static class HandFactory_ implements HandBehaviourFactory {

        public Object create(HandState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Hand'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HandState state, Object... args) {
        return new Hand(state);
    
      }
    }
}
