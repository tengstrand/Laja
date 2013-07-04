package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileState;

import static net.sf.laja.example.file.behaviour.FileCreator.FileBehaviour;

public class FileExceptions extends FileBehaviour {
    private final Directory directory;

    public FileExceptions(FileState state, Directory directory) {
        super(state);

        this.directory = directory;
    }

    private String getErrorMessage(String operation) {
        return "Could not " + operation + " file '" + s.filename + "' in directory '" + directory.directoryPath + "'";
    }

    public void throwOperationException(String operation, Exception e) {
        throw new RuntimeException(getErrorMessage(operation), e);
    }

    public void throwException(String message) {
        String errorMessage = "The file '" + s.filename + "' in directory '" + directory.directoryPath + "' " + message;
        throw new RuntimeException(errorMessage);
    }
}
