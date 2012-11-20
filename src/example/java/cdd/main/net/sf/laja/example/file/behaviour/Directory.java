package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.state.DirectoryState;

import java.io.File;

public class Directory extends DirectoryFactory {
    protected String directoryPath;
    protected DirectoryList directories;
    protected ClosedFileList files;

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

    // (factory)
    public Directory asDirectory() {
        return new Directory(state);
    }

    public TextDirectory asTextDirectory() {
        return new TextDirectory(state, directoryPath, directories, files);
    }

    private void init(Directory directory, File fileOrDir) {
        if (fileOrDir.isDirectory()) {
            initDirectory(directory, fileOrDir);
        } else {
            directoryPath = fileOrDir.getParent();
            directories = Directory.createList().asDirectoryList();
            files = FileFactory.createList().asClosedFileList(directory);
        }
    }

    private void initDirectory(Directory directory, File dir) {
        DirectoryListEncapsulator directoryListEncapsulator = Directory.createList();
        FileListEncapsulator fileListEncapsulator = FileFactory.createList();

        for (File fileOrDir : dir.listFiles()) {
            if (fileOrDir.isDirectory()) {
                directoryListEncapsulator.add(Directory.directoryPath(fileOrDir.getPath()));
            } else {
                fileListEncapsulator.add(FileFactory.filename(fileOrDir.getName()));
            }
        }
        directoryPath = dir.getAbsolutePath();
        directories = directoryListEncapsulator.asDirectoryList();
        files = fileListEncapsulator.asClosedFileList(directory);
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
