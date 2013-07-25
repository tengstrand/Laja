package net.sf.laja.example.file;

import net.sf.laja.example.file.state.FileState;
import net.sf.laja.example.file.text.TextFile;

public class ClosedFile extends FileCreator.FileBehaviour {
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
