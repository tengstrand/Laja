package net.sf.laja.cdd.state.toe;

import net.sf.laja.cdd.state.Certificate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class ToeStateSetBuilder {
    private final Certificate certificate;
    private final ToeStateSet states;

    public ToeStateSetBuilder() {
        certificate = Certificate.get(new ToeStateImpl());
        states = ToeStateHashSet.emptySet();
    }

    public ToeStateSetBuilder(ToeStateSet states) {
        this.states = states;
        certificate = Certificate.get(new ToeStateImpl());
    }

    public ToeStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<ToeStateBuilder> getStateBuilders() {
        List<ToeStateBuilder> builders = new ArrayList<ToeStateBuilder>(states.size());

        for (ToeState state : states) {
            builders.add(new ToeStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(ToeStateBuilder builder) {
        states.add(builder.getToeState(certificate));
    }

    public void add(ToeState state) {
        states.add(state);
    }

    public boolean remove(ToeState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(ToeStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "ToeStateSetBuilder{" + states + "}";
    }
}