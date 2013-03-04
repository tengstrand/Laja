package net.sf.laja.example.person.state;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class BmiStateListBuilder {
    private final Certificate certificate;
    private final BmiStateList states;

    public BmiStateListBuilder() {
        certificate = Certificate.get(new BmiStateImpl());
        states = BmiStateArrayList.emptyList();
    }

    public BmiStateListBuilder(BmiStateList states) {
        this.states = states;
        certificate = Certificate.get(new BmiStateImpl());
    }

    public BmiStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<BmiStateBuilder> getStateBuilders() {
        List<BmiStateBuilder> builders = new ArrayList<BmiStateBuilder>(states.size());

        for (BmiState state : states) {
            builders.add(new BmiStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(BmiStateBuilder builder) {
        states.add(builder.getBmiState(certificate));
    }

    public void add(BmiState state) {
        states.add(state);
    }

    public void add(int index, BmiState state) {
        states.add(index, state);
    }

    public void addAll(int index, BmiStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, BmiState state) {
        states.set(index, state);
    }

    public boolean remove(BmiState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(BmiStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "BmiStateListBuilder{" + states + "}";
    }
}
