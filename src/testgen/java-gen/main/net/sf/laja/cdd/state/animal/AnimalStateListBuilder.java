package net.sf.laja.cdd.state.animal;

import java.util.ArrayList;
import java.util.List;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class AnimalStateListBuilder {
    private final Certificate certificate;
    private final AnimalStateList states;

    public AnimalStateListBuilder() {
        certificate = Certificate.get(new AnimalStateImpl());
        states = AnimalStateArrayList.emptyList();
    }

    public AnimalStateListBuilder(AnimalStateList states) {
        this.states = states;
        certificate = Certificate.get(new AnimalStateImpl());
    }

    public AnimalStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<AnimalStateBuilder> getStateBuilders() {
        List<AnimalStateBuilder> builders = new ArrayList<AnimalStateBuilder>(states.size());

        for (AnimalState state : states) {
            builders.add(new AnimalStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(AnimalStateBuilder builder) {
        states.add(builder.getAnimalState(certificate));
    }

    public void add(AnimalState state) {
        states.add(state);
    }

    public void add(int index, AnimalState state) {
        states.add(index, state);
    }

    public void addAll(int index, AnimalStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, AnimalState state) {
        states.set(index, state);
    }

    public boolean remove(AnimalState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(AnimalStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "AnimalStateListBuilder{" + states + "}";
    }
}
