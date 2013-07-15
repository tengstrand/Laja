package net.sf.laja.example.file;

import net.sf.laja.example.file.text.TextFile;
import net.sf.laja.example.file.state.FileState;

public class ClosedFile extends FileCreator.FileBehaviour {
    private Directory directory;

    public ClosedFile(FileState state, Directory directory) {
        super(state);

        this.directory = directory;
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return new WritableFile(s, directory, createIfNotExists);
    }

    public TextFile asTextFile() {
        return new TextFile(s, directory);
    }
}
