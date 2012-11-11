package net.sf.laja.example.file.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.file.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.file.state.FileState;

public class FileValueFactory extends FileValue {

    public FileValueFactory(FileState state) {
        super(state);
    }

    public FileValueFactory(FileState state, FileStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

  // 1
    public static FileEncapsulator filename(String filename) {
        return new FileCreator().new Filename_().filename(filename);
    }

    public static FileBuilder build() {
        return new FileBuilder();
    }

    public static FileListCreator createList(FileEncapsulator... encapsulators) {
        return new FileListCreator(encapsulators);
    }

    public static class ClosedFileFactory_ implements FileStateBehaviourFactory {
        private final FileStateBuilder builder;

        public ClosedFileFactory_(FileStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(FileState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'ClosedFile'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(FileState state, Object... args) {
        Directory directory = (Directory)args[0];

        return new ClosedFile(state, directory);
    
      }
    }

    public static class WritableFileFactory_ implements FileStateBehaviourFactory {
        private final FileStateBuilder builder;

        public WritableFileFactory_(FileStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(FileState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'WritableFile'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(FileState state, Object... args) {
        Directory directory = (Directory)args[0];
        boolean createIfNotExists = (Boolean)args[1];

        return new WritableFile(state, directory, createIfNotExists);
    
      }
    }
}
