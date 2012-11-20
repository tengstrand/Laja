package net.sf.laja.cdd.behaviour.other;

import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBehaviourFactory;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialValue;

public class OtherTerrestrialValueFactory extends TerrestrialValue {

    public OtherTerrestrialValueFactory(TerrestrialState state) {
        super(state);
    }

    public OtherTerrestrialValueFactory(TerrestrialState state, TerrestrialStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static OtherTerrestrialCreator.LeftEye_ numberOfLegs(int numberOfLegs) {
        return new OtherTerrestrialCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static OtherTerrestrialBuilder build() {
        return new OtherTerrestrialBuilder();
    }

    public static OtherTerrestrialListEncapsulator createList(OtherTerrestrialEncapsulator... encapsulators) {
        return new OtherTerrestrialListEncapsulator(encapsulators);
    }

    public static class OtherTerrestrialFactory_ implements TerrestrialStateBehaviourFactory {
        private final TerrestrialStateBuilder builder;

        public OtherTerrestrialFactory_(TerrestrialStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(TerrestrialState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'OtherTerrestrial'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TerrestrialState state, Object... args) {
        return new OtherTerrestrial(state);
    
      }
    }
}
