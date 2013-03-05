package net.sf.laja.cdd.behaviour.monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;

public class MonsterFactory extends MonsterBehaviour {

    public MonsterFactory(MonsterState state) {
        super(state);
    }

    public static MonsterCreator.NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
        return new MonsterCreator().new NumberOfLegs_().numberOfLegs(numberOfLegs);
    }

    public static MonsterBuilder build() {
        return new MonsterBuilder();
    }

    public static MonsterSetEncapsulator createSet(MonsterEncapsulator... encapsulators) {
        return new MonsterSetEncapsulator(encapsulators);
    }

    public static MonsterListEncapsulator createList(MonsterEncapsulator... encapsulators) {
        return new MonsterListEncapsulator(encapsulators);
    }

    public static class MonsterFactory_ implements MonsterBehaviourFactory {

        public Object create(MonsterState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Monster'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(MonsterState state, Object... args) {
        return new Monster(state);
    
      }
    }
}
