package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;
import java.io.File;

public class DirectoryBuilder {
    public final DirectoryStateBuilder builder;

    public DirectoryBuilder() {
        builder = DirectoryStateImpl.build();
    }

    public DirectoryBuilder(DirectoryState state) {
        builder = new DirectoryStateBuilderImpl(state);
    }

    public DirectoryBuilder(DirectoryState state, Object encapsulator) {
        builder = new DirectoryStateBuilderImpl(state, encapsulator);
    }

    public DirectoryBuilder withDirectoryPath(String directoryPath) {
        builder.withDirectoryPath(directoryPath);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Directory asDirectory() {
        return (Directory)builder.as(new DirectoryFactory.DirectoryFactory_());
    }
}
