package net.sf.laja.example.file.state;

import net.sf.laja.example.file.state.Certificate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class FileStateSetBuilder {
    private final Certificate certificate;
    private final FileStateSet states;

    public FileStateSetBuilder() {
        certificate = Certificate.get(new FileStateImpl());
        states = FileStateHashSet.emptySet();
    }

    public FileStateSetBuilder(FileStateSet states) {
        this.states = states;
        certificate = Certificate.get(new FileStateImpl());
    }

    public FileStateSet getStateSet(Certificate certificate) {
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

    public boolean remove(FileState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(FileStateSetBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "FileStateSetBuilder{" + states + "}";
    }
}
