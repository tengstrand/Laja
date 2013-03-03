package net.sf.laja.example.file.behaviour;
import net.sf.laja.example.file.state.*;
import net.sf.laja.example.file.state.FileState;

public class FileCreator {
    private final FileStateBuilder builder = FileStateImpl.build();

    public class Filename_ {
        public FileEncapsulator filename(String filename) {
            builder.withFilename(filename);
            return create();
        }
    }

    public FileEncapsulator create() {
        return new FileEncapsulator(builder);
     }
}
