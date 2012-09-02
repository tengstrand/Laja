package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class MonsterValue implements MonsterElement {
    protected final MonsterState state;
    protected MonsterStateBuilder stateBuilder;

    public MonsterValue(MonsterState state) {
        this.state = state;
    }

    public MonsterValue(MonsterState state, MonsterStateBuilder stateBuilder) {
        this.state = state;
        this.stateBuilder = stateBuilder;
    }

    public MonsterState getState(Certificate certificate) {
        return state;
    }

    public void addToList(MonsterStateList stateList) {
        stateList.add(state);
    }

    public void addToList(MonsterStateListBuilder listBuilder) {
        listBuilder.add(state);
    }

    public void addToList(MonsterStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(state, mutator);
    }

    public void addToList(int index, MonsterStateListBuilder listBuilder, Object mutator) {
        listBuilder.add(index, state, mutator);
    }

    public void setInList(int index, MonsterStateListBuilder listBuilder, Object accessor) {
        listBuilder.set(index, state, accessor);
    }

    public boolean removeFromList(MonsterStateListBuilder listBuilder, Object mutator) {
        return listBuilder.remove(state, mutator);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return state.valueEquals(((MonsterValue)o).state);
    }

    @Override
    public int hashCode() {
        return state.valueHashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + state;
    }
}
