package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.state.head.*;

public class HeadValueFactory extends HeadValue {

    public HeadValueFactory(HeadState state) {
        super(state);
    }

    public HeadValueFactory(HeadState state, HeadStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static HeadCreator.LeftEye_ headWeightInGrams(double headWeightInGrams) {
        return new HeadCreator().new HeadWeightInGrams_().headWeightInGrams(headWeightInGrams);
    }

    public static HeadBuilder build() {
        return new HeadBuilder();
    }

    public static class HeadFactory_ implements HeadStateBehaviourFactory {
        private final HeadStateBuilder builder;

        public HeadFactory_(HeadStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(HeadState state, Object... args) {
            Object result = create_(state, builder, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Head'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HeadState state, HeadStateBuilder stateBuilder, Object... args) {
        return new Head(state, stateBuilder);
    
      }
    }
}
