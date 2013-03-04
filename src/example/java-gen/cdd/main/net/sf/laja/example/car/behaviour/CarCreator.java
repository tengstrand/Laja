package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.CarState;

public class CarCreator {
    private final CarStateBuilder builder = CarStateImpl.build();

    public class Size_ {
        public Name_ size(VehicleSizeEncapsulator size) {
            builder.withSize(size.builder);
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
        public CarEncapsulator color(String color) {
            builder.withColor(color);
            return create();
        }
    }

    public CarEncapsulator create() {
        return new CarEncapsulator(builder);
     }
}
