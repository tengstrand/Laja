package net.sf.laja.example.file.behaviour.text;

import net.sf.laja.example.file.behaviour.ClosedFileList;
import net.sf.laja.example.file.behaviour.DirectoryList;
import net.sf.laja.example.file.state.DirectoryBehaviour;
import net.sf.laja.example.file.state.DirectoryState;

public class TextDirectory extends DirectoryBehaviour {
    private final String directoryPath;
    private final TextDirectoryList directories;
    private final TextFileList files;

    private static final String DIR = "(dir)  ";
    public static final String FILE = "(file) ";

    public TextDirectory(DirectoryState state, String directoryPath, DirectoryList directories, ClosedFileList files) {
        super(state);

        this.directoryPath = directoryPath;
        this.directories = directories.asTextDirectoryList();
        this.files = files.asTextFileList();
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
