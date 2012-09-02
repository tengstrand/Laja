package net.sf.laja.cdd.state.monster;

public interface MonsterElement {
    public void addToList(MonsterStateList stateList);
    public void addToList(MonsterStateListBuilder listBuilder);
    public void addToList(MonsterStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, MonsterStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, MonsterStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(MonsterStateListBuilder listBuilder, Object mutator);
}
