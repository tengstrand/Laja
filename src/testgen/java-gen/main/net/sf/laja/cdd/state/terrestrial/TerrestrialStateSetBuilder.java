package net.sf.laja.cdd.state.terrestrial;

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
public final class TerrestrialStateSetBuilder {
    private final Certificate certificate;
    private final TerrestrialStateSet states;

    public TerrestrialStateSetBuilder() {
        certificate = Certificate.get(new TerrestrialStateImpl());
        states = TerrestrialStateHashSet.emptySet();
    }

    public TerrestrialStateSetBuilder(TerrestrialStateSet states) {
        this.states = states;
        certificate = Certificate.get(new TerrestrialStateImpl());
    }

    public TerrestrialStateSet getStateSet(Certificate certificate) {
        return states;
    }

    public List<TerrestrialStateBuilder> getStateBuilders() {
        List<TerrestrialStateBuilder> builders = new ArrayList<TerrestrialStateBuilder>(states.size());

        for (TerrestrialState state : states) {
            builders.add(new TerrestrialStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(TerrestrialStateBuilder builder) {
        states.add(builder.getTerrestrialState(certificate));
    }

    public void add(TerrestrialState state) {
        states.add(state);
    }

    public boolean remove(TerrestrialState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(TerrestrialStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "TerrestrialStateSetBuilder{" + states + "}";
    }
}
