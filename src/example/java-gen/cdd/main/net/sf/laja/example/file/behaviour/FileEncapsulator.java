package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileStateBuilder;

public class FileEncapsulator {
    public final FileStateBuilder builder;

    public FileEncapsulator(FileStateBuilder builder) {
        this.builder = builder;
    }

    public ClosedFile asClosedFile(Directory directory) {
        return (ClosedFile)builder.as(new FileFactory.ClosedFileFactory_(builder), directory);
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return (WritableFile)builder.as(new FileFactory.WritableFileFactory_(builder), directory, createIfNotExists);
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
