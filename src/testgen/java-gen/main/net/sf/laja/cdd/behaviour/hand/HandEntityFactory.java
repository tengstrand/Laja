package net.sf.laja.cdd.behaviour.hand;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.hand.HandState;
import java.util.Arrays;
import net.sf.laja.cdd.state.hand.*;
import java.util.ArrayList;

public class HandEntityFactory extends HandEntity {

    public HandEntityFactory(HandState state) {
        super(state);
    }

    public HandEntityFactory(HandState state, HandStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static HandEncapsulator area(int area) {
        return new HandCreator().new Area_().area(area);
    }

    public static HandBuilder build() {
        return new HandBuilder();
    }

    public static HandListCreator createList(HandEncapsulator... encapsulators) {
        return new HandListCreator(encapsulators);
    }

    public static class HandFactory_ implements HandStateBehaviourFactory {
        private final HandStateBuilder builder;

        public HandFactory_(HandStateBuilder builder) {
            this.builder = builder;
        }

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
