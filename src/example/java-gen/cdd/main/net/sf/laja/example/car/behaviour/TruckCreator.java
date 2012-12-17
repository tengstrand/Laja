package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.TruckStateBuilder;
import net.sf.laja.example.car.state.TruckStateImpl;

public class TruckCreator {
    private final TruckStateBuilder builder = TruckStateImpl.build();

    public class LengthInCentimeters_ {
        public WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
            builder.withLengthInCentimeters(lengthInCentimeters);
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public Type_ weightInKilograms(int weightInKilograms) {
            builder.withWeightInKilograms(weightInKilograms);
            return new Type_();
        }
    }

    public class Type_ {
        public Color_ type(TruckTypeEncapsulator type) {
            builder.withType(type.builder);
            return new Color_();
        }
    }

    public class Color_ {
        public Owner_ color(String color) {
            builder.withColor(color);
            return new Owner_();
        }
    }

    public class Owner_ {
        public TruckEncapsulator owner(OwnerEncapsulator owner) {
            builder.withOwner(owner.builder);
            return create();
        }
    }

    public TruckEncapsulator create() {
        return new TruckEncapsulator(builder);
     }
}
