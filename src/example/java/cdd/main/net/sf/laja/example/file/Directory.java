package net.sf.laja.example.file;

import com.google.common.collect.ImmutableList;
import net.sf.laja.example.file.state.DirectoryState;
import net.sf.laja.example.file.text.TextDirectory;

import java.io.File;

public class Directory extends DirectoryCreator.DirectoryBehaviour {
    protected String directoryPath;
    protected ImmutableList<Directory> directories;
    protected ImmutableList<ClosedFile> files;

    public Directory(DirectoryState state) {
        super(state);

        File fileOrDir = new File(state.getDirectoryPath());

        if (!fileOrDir.exists()) {
            throw new IllegalStateException("Directory does not exist: " + state.getDirectoryPath());
        }
        if (!fileOrDir.isDirectory()) {
            throw new IllegalStateException("No directory: " + state.getDirectoryPath());
        }
        init(this, fileOrDir);
    }

    public TextDirectory asTextDirectory() {
        return new TextDirectory(state, directoryPath, directories, files);
    }

    private void init(Directory directory, File fileOrDir) {
        if (fileOrDir.isDirectory()) {
            initDirectory(directory, fileOrDir);
        } else {
            directoryPath = fileOrDir.getParent();
            directories = ImmutableList.of();
            files = ImmutableList.of();
        }
    }

    private void initDirectory(Directory directory, File dir) {
        ImmutableList.Builder<Directory> directoryBuilder = ImmutableList.builder();
        ImmutableList.Builder<ClosedFile> fileBuilder = ImmutableList.builder();

        for (File fileOrDir : dir.listFiles()) {
            if (fileOrDir.isDirectory()) {
                directoryBuilder.add(DirectoryCreator.createDirectory().directoryPath(fileOrDir.getPath()).asDirectory());
            } else {
                fileBuilder.add(FileCreator.createFile().filename(fileOrDir.getName()).asClosedFile(directory));
            }
        }
        directoryPath = dir.getAbsolutePath();
        directories = directoryBuilder.build();
        files = fileBuilder.build();
    }

    public static boolean isDirectory(String path) {
        return new File(path).isDirectory();
    }

    public static void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
