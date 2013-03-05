package net.sf.laja.cdd.behaviour.terrestrial;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.behaviour.eye.Eye;
import java.util.Arrays;
import net.sf.laja.cdd.state.terrestrial.*;
import java.util.ArrayList;

public class TerrestrialFactory extends TerrestrialBehaviour {

    public TerrestrialFactory(TerrestrialState state) {
        super(state);
    }

    public static TerrestrialCreator.LeftEye_ numberOfLegs(int numberOfLegs) {
        return new TerrestrialCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static TerrestrialBuilder build() {
        return new TerrestrialBuilder();
    }

    public static TerrestrialSetEncapsulator createSet(TerrestrialEncapsulator... encapsulators) {
        return new TerrestrialSetEncapsulator(encapsulators);
    }

    public static TerrestrialListEncapsulator createList(TerrestrialEncapsulator... encapsulators) {
        return new TerrestrialListEncapsulator(encapsulators);
    }

    public static class TerrestrialFactory_ implements TerrestrialBehaviourFactory {

        public Object create(TerrestrialState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Terrestrial'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TerrestrialState state, Object... args) {
        return new Terrestrial(state);
    
      }
    }
}
