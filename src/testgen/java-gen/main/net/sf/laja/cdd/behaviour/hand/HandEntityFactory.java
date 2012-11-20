package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.HandEntity;
import net.sf.laja.cdd.state.hand.HandState;
import net.sf.laja.cdd.state.hand.HandStateBehaviourFactory;
import net.sf.laja.cdd.state.hand.HandStateBuilder;

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

    public static HandListEncapsulator createList(HandEncapsulator... encapsulators) {
        return new HandListEncapsulator(encapsulators);
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
