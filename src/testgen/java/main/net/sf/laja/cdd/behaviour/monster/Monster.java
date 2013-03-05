package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;

public class Monster extends MonsterFactory {
    private final Head head;

    public Monster(MonsterState state) {
        super(state);

        head = new Head(state.getHead());
    }

    // (factory)
    public Monster asMonster() {
        return new Monster(state);
    }
}
