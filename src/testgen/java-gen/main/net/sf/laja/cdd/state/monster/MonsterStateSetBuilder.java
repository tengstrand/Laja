package net.sf.laja.cdd.state.monster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class MonsterStateSetBuilder {
    private final Certificate certificate;
    private final MonsterStateSet states;

    public MonsterStateSetBuilder() {
        certificate = Certificate.get(new MonsterStateImpl());
        states = MonsterStateHashSet.emptySet();
    }

    public MonsterStateSetBuilder(MonsterStateSet states) {
        this.states = states;
        certificate = Certificate.get(new MonsterStateImpl());
    }

    public MonsterStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<MonsterStateBuilder> getStateBuilders() {
        List<MonsterStateBuilder> builders = new ArrayList<MonsterStateBuilder>(states.size());

        for (MonsterState state : states) {
            builders.add(new MonsterStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(MonsterStateBuilder builder) {
        states.add(builder.getMonsterState(certificate));
    }

    public void add(MonsterState state) {
        states.add(state);
    }

    public boolean remove(MonsterState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(MonsterStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "MonsterStateSetBuilder{" + states + "}";
    }
}
