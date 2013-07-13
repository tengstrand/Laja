package net.sf.laja.example.file.behaviour;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;
import net.sf.laja.example.file.state.FileState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.file.state.FileState.FileMutableState;

@Creator
public class FileCreator implements FileCreatorMaker {
    private final FileMutableState state;

    public ClosedFile asClosedFile(Directory directory) {
        return new ClosedFile(state.asImmutable(), directory);
    }

    public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
        return new WritableFile(state.asImmutable(), directory, createIfNotExists);
    }

    // ===== Generated code =====

    private static final String filename_ = "filename";

    // --- Constructors ---

    public static FileFactory createFile() {
        return new FileCreator(new FileMutableState()).new FileFactory();
    }

    public static FileBuilder buildFile() {
        return new FileBuilder();
    }

    public static FileListBuilder createFileList(FileCreator... creators) {
        return new FileListBuilder(creators);
    }

    public static FileSetBuilder createFileSet(FileCreator... creators) {
        return new FileSetBuilder(creators);
    }

    public static FileMapBuilder createFileMap(FileMapEntryBuilder... builders) {
        return new FileMapBuilder(builders);
    }

    public static FileMapEntryBuilder createFileEntry(Object key, FileCreator creator) {
        return new FileMapEntryBuilder(key, creator);
    }

    public static FileMapEntryBuilder fileEntry(Object key, FileBuilder builder) {
        return new FileMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class FileFactory {

        public FileCreator filename(String filename) {
            return new _Filename().filename(filename);
        }

        // filename
        public class _Filename {
            public FileCreator filename(String filename) {
                state.filename = filename;
                return new FileCreator(state);
            }
        }
    }

    // --- Constructor ---

    public FileCreator(FileMutableState state) {
        this.state = state;
    }

    public FileState asState() {
        return state.asImmutable();
    }

    public FileMutableState asMutableState() {
        return state;
    }

    // --- With methods ---

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    // --- Behaviour ---

    public static class FileBehaviour {
        public final FileState s;

        public FileBehaviour(FileState s) {
            this.s = s;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof FileBehaviour)) return false;

            return s.equals(((FileBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- MutableBehaviour ---

    public static class FileMutableBehaviour {
        private FileMutableState s;

        public FileMutableBehaviour(FileMutableState s) {
            this.s = s;
        }

        public FileState state() {
            return s.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof FileMutableBehaviour)) return false;

            return s.equals(((FileMutableBehaviour)that).s);
        }

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + s;
        }
    }

    // --- Builder ---

    public static class FileBuilder implements FileCreatorMaker {
        private final FileMutableState state;

        public FileBuilder() {
            this.state = new FileMutableState();
        }

        public FileBuilder(FileMutableState state) {
            this.state = state;
        }

        public FileBuilder withFilename(String filename) { state.filename = filename; return this; }

        public ClosedFile asClosedFile(Directory directory) {
            return new ClosedFile(state.asImmutable(), directory);
        }

        public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
            return new WritableFile(state.asImmutable(), directory, createIfNotExists);
        }

        public FileState asState() {
            return state.asImmutable();
        }

        public FileMutableState asMutableState() {
            return state;
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return state.validate(validators);
        }
    }

    // --- ListBuilder ---

    public static class FileListBuilder implements Iterable<FileCreator> {
        private List<FileCreator> creators;

        public FileListBuilder(FileCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public FileListBuilder(Collection<FileCreator> creators) {
            this.creators = new ArrayList<FileCreator>();
            this.creators.addAll(creators);
        }

        // asClosedFileList(Directory directory) : ImmutableList<ClosedFile>

        public ImmutableList<ClosedFile> asClosedFileList(Directory directory) {
            ImmutableList.Builder<ClosedFile> builder = ImmutableList.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asClosedFile(directory));
            }
            return builder.build();
        }

        // asClosedFileMutableList(Directory directory) : List<ClosedFile>

        public List<ClosedFile> asClosedFileMutableList(Directory directory) {
            List<ClosedFile> result = new ArrayList<ClosedFile>();

            for (FileCreator creator : creators) {
                result.add(creator.asClosedFile(directory));
            }
            return result;
        }

        // asWritableFileList(Directory directory, boolean createIfNotExists) : ImmutableList<WritableFile>

        public ImmutableList<WritableFile> asWritableFileList(Directory directory, boolean createIfNotExists) {
            ImmutableList.Builder<WritableFile> builder = ImmutableList.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asWritableFile(directory, createIfNotExists));
            }
            return builder.build();
        }

        // asWritableFileMutableList(Directory directory, boolean createIfNotExists) : List<WritableFile>

        public List<WritableFile> asWritableFileMutableList(Directory directory, boolean createIfNotExists) {
            List<WritableFile> result = new ArrayList<WritableFile>();

            for (FileCreator creator : creators) {
                result.add(creator.asWritableFile(directory, createIfNotExists));
            }
            return result;
        }

        // asStateList() : ImmutableList<FileState>

        public ImmutableList<FileState> asStateList() {
            ImmutableList.Builder<FileState> builder = ImmutableList.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<FileMutableState>

        public List<FileMutableState> asMutableStateList() {
            List<FileMutableState> result = new ArrayList<FileMutableState>();

            for (FileCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<FileCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class FileSetBuilder implements Iterable<FileCreator> {
        private List<FileCreator> creators;

        public FileSetBuilder(FileCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public FileSetBuilder(Collection<FileCreator> creators) {
            this.creators = new ArrayList<FileCreator>();
            this.creators.addAll(creators);
        }

        // asClosedFileSet(Directory directory) : ImmutableSet<ClosedFile>

        public ImmutableSet<ClosedFile> asClosedFileSet(Directory directory) {
            ImmutableSet.Builder<ClosedFile> builder = ImmutableSet.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asClosedFile(directory));
            }
            return builder.build();
        }

        // asClosedFileMutableSet(Directory directory) : Set<ClosedFile>

        public Set<ClosedFile> asClosedFileMutableSet(Directory directory) {
            Set<ClosedFile> result = new HashSet<ClosedFile>();

            for (FileCreator creator : creators) {
                result.add(creator.asClosedFile(directory));
            }
            return result;
        }

        // asWritableFileSet(Directory directory, boolean createIfNotExists) : ImmutableSet<WritableFile>

        public ImmutableSet<WritableFile> asWritableFileSet(Directory directory, boolean createIfNotExists) {
            ImmutableSet.Builder<WritableFile> builder = ImmutableSet.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asWritableFile(directory, createIfNotExists));
            }
            return builder.build();
        }

        // asWritableFileMutableSet(Directory directory, boolean createIfNotExists) : Set<WritableFile>

        public Set<WritableFile> asWritableFileMutableSet(Directory directory, boolean createIfNotExists) {
            Set<WritableFile> result = new HashSet<WritableFile>();

            for (FileCreator creator : creators) {
                result.add(creator.asWritableFile(directory, createIfNotExists));
            }
            return result;
        }

        // asState()

        public ImmutableSet<FileState> asStateSet() {
            ImmutableSet.Builder<FileState> builder = ImmutableSet.builder();

            for (FileCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<FileMutableState> asMutableStateSet() {
            Set<FileMutableState> result = new HashSet<FileMutableState>();

            for (FileCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<FileCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class FileMapEntryBuilder {
        private final Object key;
        private final FileCreatorMaker maker;

        public FileMapEntryBuilder(Object key, FileCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public ClosedFile asClosedFile(Directory directory) {
            return maker.asClosedFile(directory);
        }

        public WritableFile asWritableFile(Directory directory, boolean createIfNotExists) {
            return maker.asWritableFile(directory, createIfNotExists);
        }

        public FileState asState() {
            return maker.asState();
        }

        public FileMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class FileMapBuilder {
        private final FileMapEntryBuilder[] entries;

        public FileMapBuilder(FileMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asClosedFileMap(Directory directory) : ImmutableMap

        public ImmutableMap asClosedFileMap(Directory directory) {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (FileMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asClosedFile(directory));
            }
            return builder.build();
        }

        // asClosedFileMutableMap(Directory directory) : Map

        public Map asClosedFileMutableMap(Directory directory) {
            Map result = new HashMap();

            for (FileMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asClosedFile(directory));
            }
            return result;
        }

        // asWritableFileMap(Directory directory, boolean createIfNotExists) : ImmutableMap

        public ImmutableMap asWritableFileMap(Directory directory, boolean createIfNotExists) {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (FileMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asWritableFile(directory, createIfNotExists));
            }
            return builder.build();
        }

        // asWritableFileMutableMap(Directory directory, boolean createIfNotExists) : Map

        public Map asWritableFileMutableMap(Directory directory, boolean createIfNotExists) {
            Map result = new HashMap();

            for (FileMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asWritableFile(directory, createIfNotExists));
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (FileMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (FileMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface FileCreatorMaker {
    ClosedFile asClosedFile(Directory directory);
    WritableFile asWritableFile(Directory directory, boolean createIfNotExists);

    FileState asState();
    FileMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}