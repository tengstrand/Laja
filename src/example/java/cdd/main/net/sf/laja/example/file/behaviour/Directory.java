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

    // (factory) (list)
    public Directory asDirectory() {
        return new Directory(state);
    }

    // (list)
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
        DirectoryListCreator directoryListCreator = Directory.createList();
        FileListCreator fileListCreator = FileFactory.createList();

        for (File fileOrDir : dir.listFiles()) {
            if (fileOrDir.isDirectory()) {
                directoryListCreator.add(Directory.directoryPath(fileOrDir.getPath()));
            } else {
                fileListCreator.add(FileFactory.filename(fileOrDir.getName()));
            }
        }
        directoryPath = dir.getAbsolutePath();
        directories = directoryListCreator.asDirectoryList();
        files = fileListCreator.asClosedFileList(directory);
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
