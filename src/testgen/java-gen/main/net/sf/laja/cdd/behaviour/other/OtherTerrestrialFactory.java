package net.sf.laja.cdd.behaviour.other;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import java.util.Arrays;
import net.sf.laja.cdd.state.terrestrial.*;
import java.util.ArrayList;

public class OtherTerrestrialFactory extends TerrestrialBehaviour {

    public OtherTerrestrialFactory(TerrestrialState state) {
        super(state);
    }

    public static OtherTerrestrialCreator.LeftEye_ numberOfLegs(int numberOfLegs) {
        return new OtherTerrestrialCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static OtherTerrestrialBuilder build() {
        return new OtherTerrestrialBuilder();
    }

    public static OtherTerrestrialSetEncapsulator createSet(OtherTerrestrialEncapsulator... encapsulators) {
        return new OtherTerrestrialSetEncapsulator(encapsulators);
    }

    public static OtherTerrestrialListEncapsulator createList(OtherTerrestrialEncapsulator... encapsulators) {
        return new OtherTerrestrialListEncapsulator(encapsulators);
    }

    public static class OtherTerrestrialFactory_ implements TerrestrialBehaviourFactory {
        private final TerrestrialStateBuilder stateBuilder;

        public OtherTerrestrialFactory_(TerrestrialStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
