package net.sf.laja.example.car.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.car.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.car.state.TruckTypeState;

public class TruckTypeValueFactory extends TruckTypeValue {

    public TruckTypeValueFactory(TruckTypeState state) {
        super(state);
    }

    public TruckTypeValueFactory(TruckTypeState state, TruckTypeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

// 2
      // 2.3
    public static TruckTypeCreator.TruckName_ numberOfWheels(int numberOfWheels) {
        return new TruckTypeCreator().new NumberOfWheels_().numberOfWheels(numberOfWheels);
    }

    public static TruckTypeBuilder build() {
        return new TruckTypeBuilder();
    }

    public static TruckTypeListCreator createList(TruckTypeEncapsulator... encapsulators) {
        return new TruckTypeListCreator(encapsulators);
    }

    public static class TruckTypeFactory_ implements TruckTypeStateBehaviourFactory {
        private final TruckTypeStateBuilder builder;

        public TruckTypeFactory_(TruckTypeStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(TruckTypeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TruckType'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(TruckTypeState state, Object... args) {
        return new TruckType(state);
    
      }
    }
}
