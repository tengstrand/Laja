package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;
import java.io.File;

public class DirectoryCreator {
    private final DirectoryStateBuilder builder = DirectoryStateImpl.build();

    public class DirectoryPath_ {
        public DirectoryEncapsulator directoryPath(String directoryPath) {
            builder.withDirectoryPath(directoryPath);
            return create();
        }
    }

    public DirectoryEncapsulator create() {
        return new DirectoryEncapsulator(builder);
     }
}
