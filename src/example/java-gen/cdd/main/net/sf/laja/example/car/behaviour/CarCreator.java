package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.behaviour.CarColor;

public class CarCreator {
    private final CarStateBuilder builder = CarStateImpl.build();

    public class LengthInCentimeters_ {
        public Name_ lengthInCentimeters(int lengthInCentimeters) {
            builder.withLengthInCentimeters(lengthInCentimeters);
            return new Name_();
        }
    }

    public class Name_ {
        public Owner_ name(String name) {
            builder.withName(name);
            return new Owner_();
        }
    }

    public class Owner_ {
        public Color_ owner(OwnerEncapsulator owner) {
            builder.withOwner(owner.builder);
            return new Color_();
        }
    }

    public class Color_ {
        public CarEncapsulator color(CarColor color) {
            builder.withColor(color);
            return create();
        }

        public CarEncapsulator color(String color) {
            builder.withColor(CarColor.valueOf(color.toUpperCase()));
            return create();
        }
    }

    public CarEncapsulator create() {
        return new CarEncapsulator(builder);
     }
}
