package net.sf.laja.cdd.behaviour.monster;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.monster.MonsterState;
import java.util.Arrays;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import java.util.ArrayList;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;

public class MonsterFactory extends MonsterBehaviour {

    public MonsterFactory(MonsterState state) {
        super(state);
    }

    public MonsterFactory(MonsterState state, MonsterStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static MonsterCreator.NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
        return new MonsterCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static MonsterBuilder build() {
        return new MonsterBuilder();
    }

    public static MonsterListEncapsulator createList(MonsterEncapsulator... encapsulators) {
        return new MonsterListEncapsulator(encapsulators);
    }

    public static class MonsterFactory_ implements MonsterStateBehaviourFactory {
        private final MonsterStateBuilder stateBuilder;

        public MonsterFactory_(MonsterStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(MonsterState state, Object... args) {
            Object result = create_(state, stateBuilder, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Monster'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(MonsterState state, MonsterStateBuilder stateBuilder, Object... args) {
        return new Monster(state, stateBuilder);
    
      }
    }
}
