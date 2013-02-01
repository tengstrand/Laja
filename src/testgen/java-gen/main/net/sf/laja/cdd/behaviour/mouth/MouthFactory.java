package net.sf.laja.cdd.behaviour.mouth;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;
import java.util.Arrays;
import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import java.util.ArrayList;
import net.sf.laja.cdd.state.mouth.*;

public class MouthFactory extends MouthBehaviour {

    public MouthFactory(MouthState state) {
        super(state);
    }

    public MouthFactory(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static MouthCreator.Height_ width(int width) {
        return new MouthCreator().new Width_().width(width);
    }

    public static MouthBuilder build() {
        return new MouthBuilder();
    }

    public static MouthSetEncapsulator createSet(MouthEncapsulator... encapsulators) {
        return new MouthSetEncapsulator(encapsulators);
    }

    public static MouthListEncapsulator createList(MouthEncapsulator... encapsulators) {
        return new MouthListEncapsulator(encapsulators);
    }

    public static class MouthFactory_ implements MouthBehaviourFactory {
        private final MouthStateBuilder stateBuilder;

        public MouthFactory_(MouthStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
