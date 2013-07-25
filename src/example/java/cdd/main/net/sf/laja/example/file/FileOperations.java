package net.sf.laja.example.file;

import net.sf.laja.example.file.state.FileState;

import java.io.File;
import java.io.IOException;

import static net.sf.laja.example.file.FileCreator.FileBehaviour;

/**
 * Handles common operations on files like getting the file name or checking if the file exists.
 *
 * In Scala this class would have been a trait. Because Java does not have traits,
 * the functionality in this class is accessed by using composition.
 */
public class FileOperations extends FileBehaviour {
    private final Directory directory;
    private final FileExceptions fileExceptions;

    public FileOperations(FileState state, Directory directory) {
        super(state);

        this.directory = directory;
        fileExceptions = new FileExceptions(state, directory);
    }

    public String getFilename() {
        return directory.directoryPath + File.separator + state.getFilename();
    }

    private File getFile() {
        return new File(getFilename());
    }

    public boolean exists() {
        return getFile().exists();
    }

    public void createIfNotExists() {
        try {
            getFile().createNewFile();
        } catch (IOException e) {
            fileExceptions.throwOperationException("create", e);
        }
    }

    public void deleteIfExists() {
        File file = new File(getFilename());
        if (exists()) {
            file.delete();
        }
    }
}
