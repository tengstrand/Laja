package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.state.FileState;
// Directory

public class FileEncapsulator implements FileStateComparable {
    public final FileStateBuilder builder;

    public FileEncapsulator(FileStateBuilder builder) {
        this.builder = builder;
    }

    public ClosedFile asClosedFile(Directory directory) {
        return (ClosedFile)builder.as(new FileFactory.ClosedFileFactory_(), directory);
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return (WritableFile)builder.as(new FileFactory.WritableFileFactory_(), directory, createIfNotExists);
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
