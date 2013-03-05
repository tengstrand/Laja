package net.sf.laja.cdd.behaviour.foot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.state.foot.FootState;

public class FootFactory extends FootBehaviour {

    public FootFactory(FootState state) {
        super(state);
    }

    public static FootCreator.Toes_ area(int area) {
        return new FootCreator().new Area_().area(area);
    }

    public static FootBuilder build() {
        return new FootBuilder();
    }

    public static FootSetEncapsulator createSet(FootEncapsulator... encapsulators) {
        return new FootSetEncapsulator(encapsulators);
    }

    public static FootListEncapsulator createList(FootEncapsulator... encapsulators) {
        return new FootListEncapsulator(encapsulators);
    }

    public static class FootFactory_ implements FootBehaviourFactory {

        public Object create(FootState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Foot'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(FootState state, Object... args) {
        return new Foot(state);
    
      }
    }
}
