package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileState;

/**
 * Responsible for creating instances of ClosedFile and WritableFile.
 */
public class FileTemplate extends FileFactory {
    public FileTemplate(FileState state) {
        super(state);
    }

    // (factory) (list)
    private ClosedFile asClosedFile(Directory directory) {
        return new ClosedFile(state, directory);
    }

    // (factory)
    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return new WritableFile(state, directory, createIfNotExists);
    }
}
