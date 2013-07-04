package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.behaviour.text.TextFile;
import net.sf.laja.example.file.state.FileState;

import static net.sf.laja.example.file.behaviour.FileCreator.FileBehaviour;

public class ClosedFile extends FileBehaviour {
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
