package net.sf.laja.example.file.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.file.state.*;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;
import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;

public class DirectoryValueFactory extends DirectoryValue {

    public DirectoryValueFactory(DirectoryState state) {
        super(state);
    }

    public DirectoryValueFactory(DirectoryState state, DirectoryStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

  // 1
    public static DirectoryEncapsulator directoryPath(String directoryPath) {
        return new DirectoryCreator().new DirectoryPath_().directoryPath(directoryPath);
    }

    public static DirectoryBuilder build() {
        return new DirectoryBuilder();
    }

    public static DirectoryListCreator createList(DirectoryEncapsulator... encapsulators) {
        return new DirectoryListCreator(encapsulators);
    }

    public static class DirectoryFactory_ implements DirectoryStateBehaviourFactory {
        private final DirectoryStateBuilder builder;

        public DirectoryFactory_(DirectoryStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(DirectoryState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Directory'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(DirectoryState state, Object... args) {
        return new Directory(state);
    
      }
    }
}
