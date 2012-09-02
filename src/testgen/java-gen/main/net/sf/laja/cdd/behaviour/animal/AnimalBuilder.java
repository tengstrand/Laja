package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalBuilder {
    public final AnimalStateBuilder builder;

    public AnimalBuilder() {
        builder = AnimalStateImpl.build();
    }

    public AnimalBuilder(AnimalState state) {
        builder = AnimalStateImpl.build(state);
    }

    public AnimalBuilder withIsTerrestrial(boolean isTerrestrial) {
        builder.withIsTerrestrial(isTerrestrial);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Animal asAnimal() {
        return (Animal)builder.as(new AnimalFactory.AnimalFactory_(builder));
    }
}
