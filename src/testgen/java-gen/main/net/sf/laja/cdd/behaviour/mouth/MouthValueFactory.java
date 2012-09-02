package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.cdd.state.mouth.*;

public class MouthValueFactory extends MouthValue {

    public MouthValueFactory(MouthState state) {
        super(state);
    }

    public MouthValueFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static MouthCreator.Height_ width(int width) {
        return new MouthCreator().new Width_().width(width);
    }

    public static MouthBuilder build() {
        return new MouthBuilder();
    }

    public static MouthListCreator createList(MouthEncapsulator... encapsulators) {
        return new MouthListCreator(encapsulators);
    }

    public static class MouthFactory_ implements MouthStateBehaviourFactory {
        private final MouthStateBuilder builder;

        public MouthFactory_(MouthStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(MouthState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Mouth'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(MouthState state, Object... args) {
        MouthSize size = (MouthSize)args[0];

        if (size == MouthSize.SMALL) {
            return new SmallMouth(state);
        }
        return new BigMouth(state);
    
      }
    }
}
