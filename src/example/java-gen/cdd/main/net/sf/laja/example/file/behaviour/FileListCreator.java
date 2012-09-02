package net.sf.laja.example.file.behaviour;

import java.util.*;
import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.state.FileState;

public class FileListCreator implements Iterable<FileEncapsulator> {
    public FileStateListBuilder stateList = new FileStateListBuilder();
    private List<FileEncapsulator> encapsulators = new ArrayList<FileEncapsulator>();

    public void add(FileEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public FileListCreator(FileEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FileEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<FileEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ClosedFileList asClosedFileList(Directory directory) {
        List<ClosedFile> result = new ArrayList<ClosedFile>();

        for (FileEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asClosedFile(directory));
        }
        return new ClosedFileList(result);
    }

    public boolean isValid() {
        for (FileEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
