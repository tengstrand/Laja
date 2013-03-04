package net.sf.laja.example.file.state;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class FileStateListBuilder {
    private final Certificate certificate;
    private final FileStateList states;

    public FileStateListBuilder() {
        certificate = Certificate.get(new FileStateImpl());
        states = FileStateArrayList.emptyList();
    }

    public FileStateListBuilder(FileStateList states) {
        this.states = states;
        certificate = Certificate.get(new FileStateImpl());
    }

    public FileStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<FileStateBuilder> getStateBuilders() {
        List<FileStateBuilder> builders = new ArrayList<FileStateBuilder>(states.size());

        for (FileState state : states) {
            builders.add(new FileStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(FileStateBuilder builder) {
        states.add(builder.getFileState(certificate));
    }

    public void add(FileState state) {
        states.add(state);
    }

    public void add(int index, FileState state) {
        states.add(index, state);
    }

    public void addAll(int index, FileStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, FileState state) {
        states.set(index, state);
    }

    public boolean remove(FileState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(FileStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "FileStateListBuilder{" + states + "}";
    }
}
