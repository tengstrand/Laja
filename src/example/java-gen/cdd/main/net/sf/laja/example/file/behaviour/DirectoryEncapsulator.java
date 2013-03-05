package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;
import java.io.File;
// Directory

public class DirectoryEncapsulator implements DirectoryStateComparable {
    public final DirectoryStateBuilder builder;

    public DirectoryEncapsulator(DirectoryStateBuilder builder) {
        this.builder = builder;
    }

    public Directory asDirectory() {
        return (Directory)builder.as(new DirectoryFactory.DirectoryFactory_());
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
