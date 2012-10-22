package net.sf.laja.cdd.state.monster;

public interface MonsterElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(MonsterStateList stateList);
    void addToList(MonsterStateList stateList);
}
