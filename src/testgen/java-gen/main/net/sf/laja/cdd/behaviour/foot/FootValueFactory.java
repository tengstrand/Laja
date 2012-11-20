package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.foot.FootStateBehaviourFactory;
import net.sf.laja.cdd.state.foot.FootStateBuilder;
import net.sf.laja.cdd.state.foot.FootValue;

public class FootValueFactory extends FootValue {

    public FootValueFactory(FootState state) {
        super(state);
    }

    public FootValueFactory(FootState state, FootStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static FootCreator.Toes_ area(int area) {
        return new FootCreator().new Area_().area(area);
    }

    public static FootBuilder build() {
        return new FootBuilder();
    }

    public static FootListEncapsulator createList(FootEncapsulator... encapsulators) {
        return new FootListEncapsulator(encapsulators);
    }

    public static class FootFactory_ implements FootStateBehaviourFactory {
        private final FootStateBuilder builder;

        public FootFactory_(FootStateBuilder builder) {
            this.builder = builder;
        }

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
