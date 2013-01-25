package net.sf.laja.cdd.state.ear;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class EarStateListBuilder {
    private final Certificate certificate;
    private final EarStateList states;

    public EarStateListBuilder() {
        certificate = Certificate.get(new EarStateImpl());
        states = EarStateArrayList.emptyList();
    }

    public EarStateListBuilder(EarStateList states) {
        this.states = states;
        certificate = Certificate.get(new EarStateImpl());
    }

    public EarStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<EarStateBuilder> getStateBuilders() {
        List<EarStateBuilder> builders = new ArrayList<EarStateBuilder>(states.size());

        for (EarState state : states) {
            builders.add(new EarStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(EarStateBuilder builder) {
        states.add(builder.getEarState(certificate));
    }

    public void add(EarState state) {
        states.add(state);
    }

    public void add(int index, EarState state) {
        states.add(index, state);
    }

    public void addAll(int index, EarStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, EarState state) {
        states.set(index, state);
    }

    public boolean remove(EarState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(EarStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "EarStateListBuilder{" + states + "}";
    }
}
