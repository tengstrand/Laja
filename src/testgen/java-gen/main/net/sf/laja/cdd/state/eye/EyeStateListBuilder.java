package net.sf.laja.cdd.state.eye;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class EyeStateListBuilder {
    private final Certificate certificate;
    private final EyeStateList states;

    public EyeStateListBuilder() {
        certificate = Certificate.get(new EyeStateImpl());
        states = EyeStateListImpl.emptyList();
    }

    public EyeStateListBuilder(EyeStateList states) {
        this.states = states;
        certificate = Certificate.get(new EyeStateImpl());
    }

    public EyeStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<EyeStateBuilder> getStateBuilders() {
        List<EyeStateBuilder> builders = new ArrayList<EyeStateBuilder>(states.size());

        for (EyeState state : states) {
            builders.add(new EyeStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(EyeStateBuilder builder) {
        states.add(builder.getEyeState(certificate));
    }

    public void add(EyeState state) {
        states.add(state);
    }

    public void add(int index, EyeState state) {
        states.add(index, state);
    }

    public void addAll(int index, EyeStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, EyeState state) {
        states.set(index, state);
    }

    public boolean remove(EyeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(EyeStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "EyeStateListBuilder{" + states + "}";
    }
}
