package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileState;
import net.sf.laja.example.file.state.FileStateBuilder;

public class FileFactory extends FileValueFactory {
    public FileFactory(FileState state) {
        super(state);
    }

    public FileFactory(FileState state, FileStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
