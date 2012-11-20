package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.behaviour.text.TextFile;
import net.sf.laja.example.file.state.FileState;

public class ClosedFile extends FileFactory {
    private Directory directory;

    public ClosedFile(FileState state, Directory directory) {
        super(state);

        this.directory = directory;
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return new WritableFile(state, directory, createIfNotExists);
    }

    public TextFile asTextFile() {
        return new TextFile(state, directory);
    }
}
