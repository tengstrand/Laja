package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileState;
import net.sf.laja.example.file.state.FileStateBuilder;
import net.sf.laja.example.file.state.FileStateBuilderImpl;
import net.sf.laja.example.file.state.FileStateImpl;

public class FileBuilder {
    public final FileStateBuilder builder;

    public FileBuilder() {
        builder = FileStateImpl.build();
    }

    public FileBuilder(FileState state) {
        builder = new FileStateBuilderImpl(state);
    }

    public FileBuilder(FileState state, Object encapsulator) {
        builder = new FileStateBuilderImpl(state, encapsulator);
    }

    public FileBuilder withFilename(String filename) {
        builder.withFilename(filename);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public ClosedFile asClosedFile(Directory directory) {
        return (ClosedFile)builder.as(new FileFactory.ClosedFileFactory_(builder), directory);
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return (WritableFile)builder.as(new FileFactory.WritableFileFactory_(builder), directory, createIfNotExists);
    }
}
