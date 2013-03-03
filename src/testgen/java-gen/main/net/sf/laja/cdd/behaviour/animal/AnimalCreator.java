package net.sf.laja.cdd.behaviour.animal;
import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalCreator {
    private final AnimalStateBuilder builder = AnimalStateImpl.build();

    public class IsTerrestrial_ {
        public AnimalEncapsulator isTerrestrial(boolean isTerrestrial) {
            builder.withIsTerrestrial(isTerrestrial);
            return create();
        }
    }

    public AnimalEncapsulator create() {
        return new AnimalEncapsulator(builder);
     }
}
