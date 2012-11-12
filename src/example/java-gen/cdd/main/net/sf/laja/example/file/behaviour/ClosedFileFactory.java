package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileState;
import net.sf.laja.example.file.state.FileStateBuilder;

public class ClosedFileFactory extends FileValueFactory {
    public ClosedFileFactory(FileState state) {
        super(state);
    }

    public ClosedFileFactory(FileState state, FileStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
