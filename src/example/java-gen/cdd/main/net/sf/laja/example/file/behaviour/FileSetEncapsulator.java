package net.sf.laja.example.file.behaviour;

import java.util.*;
import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.state.FileState;

public class FileSetEncapsulator implements Iterable<FileEncapsulator> {
    public FileStateSetBuilder stateSetBuilder = new FileStateSetBuilder();
    private List<FileEncapsulator> encapsulators = new ArrayList<FileEncapsulator>();

    public void add(FileEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public FileSetEncapsulator(FileEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FileEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FileEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ClosedFileSet asClosedFileSet(Directory directory) {
        List<ClosedFile> result = new ArrayList<ClosedFile>();

        for (FileEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asClosedFile(directory));
        }
        return new ClosedFileHashSet(result);
    }

    public WritableFileSet asWritableFileSet(Directory directory, boolean createIfNotExists) {
        List<WritableFile> result = new ArrayList<WritableFile>();

        for (FileEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asWritableFile(directory, createIfNotExists));
        }
        return new WritableFileHashSet(result);
    }

    public boolean isValid() {
        for (FileEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateSetBuilder.toString();
    }
}
