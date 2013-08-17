package net.sf.laja.example.file;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.state.converter.StringStateConverter;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.example.file.state.DirectoryState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.file.state.DirectoryState.*;

@Creator
public class DirectoryCreator implements DirectoryCreatorMaker {
    private final DirectoryMutableState state;

    public Directory asDirectory() {
        return new Directory(state.asImmutable());
    }

    // ===== Generated code =====

    public static DirectoryFactory createDirectory() {
        return new DirectoryCreator(new DirectoryMutableState()).new DirectoryFactory();
    }

    public static DirectoryCreator createDirectoryFromMap(Map directory) {
        return new DirectoryCreator(new DirectoryMutableState(toDirectoryMutableState(directory)));
    }

    public static DirectoryBuilder buildDirectory() {
        return new DirectoryBuilder();
    }

    public static DirectoryBuilder buildDirectoryFromMap(Map directory) {
        return new DirectoryBuilder(new DirectoryMutableState(toDirectoryMutableState(directory)));
    }

    public static DirectoryStringBuilder buildDirectoryFromStrings() {
        return new DirectoryStringBuilder();
    }

    public static DirectoryListBuilder createDirectoryList(DirectoryCreator... creators) {
        return new DirectoryListBuilder(creators);
    }

    public static DirectorySetBuilder createDirectorySet(DirectoryCreator... creators) {
        return new DirectorySetBuilder(creators);
    }

    public static DirectoryMapBuilder createDirectoryFromMap(DirectoryMapEntryBuilder... builders) {
        return new DirectoryMapBuilder(builders);
    }

    public static DirectoryMapEntryBuilder createDirectoryEntry(Object key, DirectoryCreator creator) {
        return new DirectoryMapEntryBuilder(key, creator);
    }

    public static DirectoryMapEntryBuilder createDirectoryEntry(Object key, DirectoryBuilder builder) {
        return new DirectoryMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class DirectoryFactory {

        public DirectoryCreator directoryPath(String directoryPath) {
            return new _DirectoryPath().directoryPath(directoryPath);
        }

        // directoryPath
        public class _DirectoryPath {
            public DirectoryCreator directoryPath(String directoryPath) {
                state.directoryPath = directoryPath;
                return new DirectoryCreator(state);
            }
        }
    }

    // --- Constructor ---

    public DirectoryCreator(DirectoryMutableState state) {
        this.state = state;
    }

    public DirectoryState asState() {
        return state.asImmutable();
    }

    public DirectoryMutableState asMutableState() {
        return state;
    }

    public Map asMap() {
        return state.asMap();
    }

    public DirectoryStringState asStringState() {
        return state.asStringState();
    }

    public DirectoryStringState asStringState(StringStateConverter stateConverter) {
        return state.asStringState(stateConverter);
    }

    // --- With methods ---

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate() {
        return state.validate();
    }

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof DirectoryCreator)) return false;

        return state.equals(((DirectoryCreator)that).state);
    }

    @Override public String toString() {
        return "DirectoryCreator" + state;
    }

    // --- Behaviour ---

    public static class DirectoryBehaviour {
        public final DirectoryState state;

        public DirectoryBehaviour(DirectoryState state) {
            this.state = state;
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidDirectoryStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof DirectoryBehaviour)) return false;

            return state.equals(((DirectoryBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class DirectoryMutableBehaviour {
        private DirectoryMutableState state;

        public DirectoryMutableBehaviour(DirectoryMutableState state) {
            this.state = state;
        }

        public DirectoryState asState() {
            return state.asImmutable();
        }

        public void assertThat(boolean condition, String attribute, String errorMessage) {
            if (!condition) {
                ValidationErrors.Builder errors = ValidationErrors.builder();
                errors.addError(state, attribute, errorMessage);
                throw new InvalidDirectoryStateException(errors.build());
            }
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof DirectoryMutableBehaviour)) return false;

            return state.equals(((DirectoryMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class DirectoryBuilder implements DirectoryCreatorMaker {
        private final DirectoryMutableState state;

        public DirectoryBuilder() {
            this.state = new DirectoryMutableState();
        }

        public DirectoryBuilder(DirectoryMutableState state) {
            this.state = state;
        }

        public DirectoryBuilder withDirectoryPath(String directoryPath) { state.directoryPath = directoryPath; return this; }

        public Directory asDirectory() {
            return new Directory(state.asImmutable());
        }

        public DirectoryState asState() {
            return state.asImmutable();
        }

        public DirectoryMutableState asMutableState() {
            return state;
        }

        public Map asMap() {
            return state.asMap();
        }

        public DirectoryStringState asStringState() {
            return state.asStringState();
        }

        public DirectoryStringState asStringState(StringStateConverter stateConverter) {
            return state.asStringState(stateConverter);
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate() {
            return state.validate();
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof DirectoryBuilder)) return false;

            return state.equals(((DirectoryBuilder)that).state);
        }

        @Override public String toString() {
            return "DirectoryBuilder" + state;
        }
    }

    // --- String builder ---

    public static class DirectoryStringBuilder {
        private final DirectoryStringState state;

        public DirectoryStringBuilder() {
            this.state = new DirectoryStringState();
        }

        public DirectoryStringBuilder(DirectoryStringState state) {
            this.state = state;
        }

        public DirectoryStringBuilder withDirectoryPath(String directoryPath) { state.directoryPath = directoryPath; return this; }

        public Directory asDirectory() {
            return new DirectoryBuilder(state.asMutable()).asDirectory();
        }

        public DirectoryState asState() {
            return state.asImmutable();
        }

        public DirectoryMutableState asMutableState() {
            return state.asMutable();
        }

        public DirectoryStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof DirectoryStringBuilder)) return false;

            return state.equals(((DirectoryStringBuilder)that).state);
        }

        @Override public String toString() {
            return "DirectoryStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class DirectoryListBuilder implements Iterable<DirectoryCreator> {
        private List<DirectoryCreator> creators;

        public DirectoryListBuilder(DirectoryCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public DirectoryListBuilder(Collection<DirectoryCreator> creators) {
            this.creators = new ArrayList<DirectoryCreator>();
            this.creators.addAll(creators);
        }

        // asDirectoryList() : ImmutableList<Directory>

        public ImmutableList<Directory> asDirectoryList() {
            ImmutableList.Builder<Directory> builder = ImmutableList.builder();

            for (DirectoryCreator creator : creators) {
                builder.add(creator.asDirectory());
            }
            return builder.build();
        }

        // asDirectoryMutableList() : List<Directory>

        public List<Directory> asDirectoryMutableList() {
            List<Directory> result = new ArrayList<Directory>();

            for (DirectoryCreator creator : creators) {
                result.add(creator.asDirectory());
            }
            return result;
        }

        // asStateList() : ImmutableList<DirectoryState>

        public ImmutableList<DirectoryState> asStateList() {
            ImmutableList.Builder<DirectoryState> builder = ImmutableList.builder();

            for (DirectoryCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<DirectoryMutableState>

        public List<DirectoryMutableState> asMutableStateList() {
            List<DirectoryMutableState> result = new ArrayList<DirectoryMutableState>();

            for (DirectoryCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<DirectoryCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class DirectorySetBuilder implements Iterable<DirectoryCreator> {
        private List<DirectoryCreator> creators;

        public DirectorySetBuilder(DirectoryCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public DirectorySetBuilder(Collection<DirectoryCreator> creators) {
            this.creators = new ArrayList<DirectoryCreator>();
            this.creators.addAll(creators);
        }

        // asDirectorySet() : ImmutableSet<Directory>

        public ImmutableSet<Directory> asDirectorySet() {
            ImmutableSet.Builder<Directory> builder = ImmutableSet.builder();

            for (DirectoryCreator creator : creators) {
                builder.add(creator.asDirectory());
            }
            return builder.build();
        }

        // asDirectoryMutableSet() : Set<Directory>

        public Set<Directory> asDirectoryMutableSet() {
            Set<Directory> result = new HashSet<Directory>();

            for (DirectoryCreator creator : creators) {
                result.add(creator.asDirectory());
            }
            return result;
        }

        // asState()

        public ImmutableSet<DirectoryState> asStateSet() {
            ImmutableSet.Builder<DirectoryState> builder = ImmutableSet.builder();

            for (DirectoryCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<DirectoryMutableState> asMutableStateSet() {
            Set<DirectoryMutableState> result = new HashSet<DirectoryMutableState>();

            for (DirectoryCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<DirectoryCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class DirectoryMapEntryBuilder {
        private final Object key;
        private final DirectoryCreatorMaker maker;

        public DirectoryMapEntryBuilder(Object key, DirectoryCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public Directory asDirectory() {
            return maker.asDirectory();
        }

        public DirectoryState asState() {
            return maker.asState();
        }

        public DirectoryMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class DirectoryMapBuilder {
        private final DirectoryMapEntryBuilder[] entries;

        public DirectoryMapBuilder(DirectoryMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asDirectoryMap() : ImmutableMap

        public ImmutableMap asDirectoryMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (DirectoryMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asDirectory());
            }
            return builder.build();
        }

        // asDirectoryMutableMap() : Map

        public Map asDirectoryMutableMap() {
            Map result = new HashMap();

            for (DirectoryMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asDirectory());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (DirectoryMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (DirectoryMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface DirectoryCreatorMaker {
    Directory asDirectory();

    DirectoryState asState();
    DirectoryMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate();
}
