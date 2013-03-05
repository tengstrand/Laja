package net.sf.laja.example.person.behaviour;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;

public class BodyMassIndexFactory extends BmiBehaviour {

    public BodyMassIndexFactory(BmiState state) {
        super(state);
    }

    public static BodyMassIndexCreator.WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
        return new BodyMassIndexCreator().new HeightInCentimeters_().heightInCentimeters(heightInCentimeters);
    }

    public static BodyMassIndexBuilder build() {
        return new BodyMassIndexBuilder();
    }

    public static BodyMassIndexSetEncapsulator createSet(BodyMassIndexEncapsulator... encapsulators) {
        return new BodyMassIndexSetEncapsulator(encapsulators);
    }

    public static BodyMassIndexListEncapsulator createList(BodyMassIndexEncapsulator... encapsulators) {
        return new BodyMassIndexListEncapsulator(encapsulators);
    }

    public static class BodyMassIndexFactory_ implements BmiBehaviourFactory {

        public Object create(BmiState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'BodyMassIndex'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BmiState state, Object... args) {
        return new BodyMassIndex(state);
    
      }
    }
}
