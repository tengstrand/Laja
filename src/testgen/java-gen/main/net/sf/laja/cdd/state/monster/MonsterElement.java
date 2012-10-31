package net.sf.laja.cdd.state.monster;

public interface MonsterElement {
    MonsterState getState(MonsterStateList stateList);
    boolean contains(MonsterStateList stateList);
    void addToList(MonsterStateList stateList);
}
