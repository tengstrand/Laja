package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBehaviourFactory;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialValue;

public class TerrestrialValueFactory extends TerrestrialValue {

    public TerrestrialValueFactory(TerrestrialState state) {
        super(state);
    }

    public TerrestrialValueFactory(TerrestrialState state, TerrestrialStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TerrestrialCreator.LeftEye_ numberOfLegs(int numberOfLegs) {
        return new TerrestrialCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static TerrestrialBuilder build() {
        return new TerrestrialBuilder();
    }

    public static TerrestrialListEncapsulator createList(TerrestrialEncapsulator... encapsulators) {
        return new TerrestrialListEncapsulator(encapsulators);
    }

    public static class TerrestrialFactory_ implements TerrestrialStateBehaviourFactory {
        private final TerrestrialStateBuilder builder;

        public TerrestrialFactory_(TerrestrialStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(TerrestrialState state, Object... args) {
            Object result = create_(state, builder, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Terrestrial'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TerrestrialState state, TerrestrialStateBuilder stateBuilder, Object... args) {
        return new Terrestrial(state, stateBuilder);
    
      }
    }
}
