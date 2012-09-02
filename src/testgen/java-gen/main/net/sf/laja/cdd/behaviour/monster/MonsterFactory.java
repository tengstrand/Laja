package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;

public class MonsterFactory extends MonsterValueFactory {
    public MonsterFactory(MonsterState state) {
        super(state);
    }

    public MonsterFactory(MonsterState state, MonsterStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
