package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.state.FileState;

public class FileBuilder {
    public final FileStateBuilder builder;

    public FileBuilder() {
        builder = FileStateImpl.build();
    }

    public FileBuilder(FileState state) {
        builder = FileStateImpl.build(state);
    }

    public FileBuilder withFilename(String filename) {
        builder.withFilename(filename);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public ClosedFile asClosedFile(Directory directory) {
        return (ClosedFile)builder.as(new ClosedFileFactory.ClosedFileFactory_(builder), directory);
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return (WritableFile)builder.as(new ClosedFileFactory.WritableFileFactory_(builder), directory, createIfNotExists);
    }
}
