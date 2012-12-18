package net.sf.laja.example.file.behaviour;

import java.util.*;
import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;
import java.io.File;

public class DirectoryListEncapsulator implements Iterable<DirectoryEncapsulator> {
    public DirectoryStateListBuilder stateListBuilder = new DirectoryStateListBuilder();
    private List<DirectoryEncapsulator> encapsulators = new ArrayList<DirectoryEncapsulator>();

    public void add(DirectoryEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public DirectoryListEncapsulator(DirectoryEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (DirectoryEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<DirectoryEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public DirectoryList asDirectoryList() {
        List<Directory> result = new ArrayList<Directory>();

        for (DirectoryEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asDirectory());
        }
        return new DirectoryArrayList(result);
    }

    public boolean isValid() {
        for (DirectoryEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}
