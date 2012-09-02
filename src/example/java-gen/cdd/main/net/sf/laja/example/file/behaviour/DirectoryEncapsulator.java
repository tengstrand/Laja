package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;
import java.io.File;

public class DirectoryEncapsulator {
    public final DirectoryStateBuilder builder;

    public DirectoryEncapsulator(DirectoryStateBuilder builder) {
        this.builder = builder;
    }

    public Directory asDirectory() {
        return (Directory)builder.as(new DirectoryFactory.DirectoryFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
