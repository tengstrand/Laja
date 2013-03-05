package net.sf.laja.example.file.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.file.state.*;
import java.util.Arrays;
import java.util.ArrayList;
import net.sf.laja.example.file.state.FileState;

public class FileFactory extends FileBehaviour {

    public FileFactory(FileState state) {
        super(state);
    }

    public static FileEncapsulator filename(String filename) {
        return new FileCreator().new Filename_().filename(filename);
    }

    public static FileBuilder build() {
        return new FileBuilder();
    }

    public static FileSetEncapsulator createSet(FileEncapsulator... encapsulators) {
        return new FileSetEncapsulator(encapsulators);
    }

    public static FileListEncapsulator createList(FileEncapsulator... encapsulators) {
        return new FileListEncapsulator(encapsulators);
    }

    public static class ClosedFileFactory_ implements FileBehaviourFactory {
        private final FileStateBuilder stateBuilder;

        public ClosedFileFactory_(FileStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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

    public static class WritableFileFactory_ implements FileBehaviourFactory {
        private final FileStateBuilder stateBuilder;

        public WritableFileFactory_(FileStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
