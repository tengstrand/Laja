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

    public static DirectoryEncapsulator directoryPath(String directoryPath) {
        return new DirectoryCreator().new DirectoryPath_().directoryPath(directoryPath);
    }

    public static DirectoryBuilder build() {
        return new DirectoryBuilder();
    }

    public static DirectoryListEncapsulator createList(DirectoryEncapsulator... encapsulators) {
        return new DirectoryListEncapsulator(encapsulators);
    }

    public static class DirectoryFactory_ implements DirectoryStateBehaviourFactory {
        private final DirectoryStateBuilder stateBuilder;

        public DirectoryFactory_(DirectoryStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
