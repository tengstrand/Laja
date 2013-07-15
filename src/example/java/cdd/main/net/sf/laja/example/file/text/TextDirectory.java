package net.sf.laja.example.file.text;

import com.google.common.collect.ImmutableList;
import net.sf.laja.example.file.ClosedFile;
import net.sf.laja.example.file.Directory;
import net.sf.laja.example.file.state.DirectoryState;

import static net.sf.laja.example.file.DirectoryCreator.DirectoryBehaviour;

public class TextDirectory extends DirectoryBehaviour {
    private final String directoryPath;
    private final ImmutableList<TextDirectory> directories;
    private final ImmutableList<TextFile> files;

    private static final String DIR = "(dir)  ";
    public static final String FILE = "(file) ";

    public TextDirectory(DirectoryState state, String directoryPath, ImmutableList<Directory> directories, ImmutableList<ClosedFile> files) {
        super(state);

        this.directoryPath = directoryPath;
        this.directories = asTextDirectories(directories);
        this.files = asTextFiles(files);
    }

    private ImmutableList<TextDirectory> asTextDirectories(ImmutableList<Directory> directories) {
        ImmutableList.Builder<TextDirectory> builder = ImmutableList.<TextDirectory>builder();

        for (Directory directory : directories) {
            builder.add(directory.asTextDirectory());
        }
        return builder.build();
    }

    private ImmutableList<TextFile> asTextFiles(ImmutableList<ClosedFile> files) {
        ImmutableList.Builder<TextFile> builder = ImmutableList.<TextFile>builder();

        for (ClosedFile file : files) {
            builder.add(file.asTextFile());
        }
        return builder.build();
    }

    public String directoryTree() {
        StringBuilder builder = new StringBuilder();

        builder.append(DIR).append(directoryPath);

        buildTree("", builder);

        return builder.toString();
    }

    private void buildTree(String depth, StringBuilder builder) {
        String newDepth = depth + "  ";

        for (TextDirectory directory : directories) {
            directory.appendDirectory(newDepth, builder);
            directory.buildTree(newDepth, builder);
        }
        for (TextFile file : files) {
            file.appendFile(newDepth, builder);
        }
    }

    private void appendDirectory(String depth, StringBuilder builder) {
        builder.append("\n").append(DIR).append(depth).append(directoryPath);
    }
}
