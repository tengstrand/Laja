package net.sf.laja.cdd.behaviour.head;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthArrayList;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.head.HeadStateBuilder;

public class HeadFactory extends HeadBehaviour {

    public HeadFactory(HeadState state) {
        super(state);
    }

    public static HeadCreator.LeftEye_ headWeightInGrams(double headWeightInGrams) {
        return new HeadCreator().new HeadWeightInGrams_().headWeightInGrams(headWeightInGrams);
    }

    public static HeadBuilder build() {
        return new HeadBuilder();
    }

    public static HeadSetEncapsulator createSet(HeadEncapsulator... encapsulators) {
        return new HeadSetEncapsulator(encapsulators);
    }

    public static HeadListEncapsulator createList(HeadEncapsulator... encapsulators) {
        return new HeadListEncapsulator(encapsulators);
    }

    public static class HeadFactory_ implements HeadBehaviourFactory {

        public Object create(HeadState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Head'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HeadState state, Object... args) {
        return new Head(state);
    
      }
    }
}
