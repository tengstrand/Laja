package net.sf.laja.cdd.behaviour.terrestrial;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateBuilder;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.behaviour.eye.Eye;
import java.util.Arrays;
import net.sf.laja.cdd.state.terrestrial.*;
import java.util.ArrayList;

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

    public static TerrestrialListCreator createList(TerrestrialEncapsulator... encapsulators) {
        return new TerrestrialListCreator(encapsulators);
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
