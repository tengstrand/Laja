package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.ToeEntity;
import net.sf.laja.cdd.state.toe.ToeState;
import net.sf.laja.cdd.state.toe.ToeStateBehaviourFactory;
import net.sf.laja.cdd.state.toe.ToeStateBuilder;

public class ToeEntityFactory extends ToeEntity {

    public ToeEntityFactory(ToeState state) {
        super(state);
    }

    public ToeEntityFactory(ToeState state, ToeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static ToeCreator.Weight_ length(int length) {
        return new ToeCreator().new Length_().length(length);
    }

    public static ToeBuilder build() {
        return new ToeBuilder();
    }

    public static ToeListEncapsulator createList(ToeEncapsulator... encapsulators) {
        return new ToeListEncapsulator(encapsulators);
    }

    public static class ToeFactory_ implements ToeStateBehaviourFactory {
        private final ToeStateBuilder builder;

        public ToeFactory_(ToeStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(ToeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Toe'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ToeState state, Object... args) {
        return new Toe(state);
    
      }
    }

    public static class ValToeFactory_ implements ToeStateBehaviourFactory {
        private final ToeStateBuilder builder;

        public ValToeFactory_(ToeStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(ToeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'ValToe'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ToeState state, Object... args) {
        return new ValToe(state);
    
      }
    }
}
