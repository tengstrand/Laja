package net.sf.laja.example.file.behaviour;

import net.sf.laja.example.file.state.FileBehaviour;
import net.sf.laja.example.file.state.FileState;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WritableFile extends FileBehaviour {
    private boolean isOpen;
    private final Directory directory;
    private final FileOperations fileOperations;
    private final FileExceptions fileExceptions;

    private FileOutputStream outputStream;
    private BufferedWriter writer;

    public WritableFile(FileState state, Directory directory, boolean createIfNotExists) {
        super(state);

        this.directory = directory;
        fileOperations = new FileOperations(state, directory);
        fileExceptions = new FileExceptions(state, directory);

        String filename = fileOperations.getFilename();

        if (createIfNotExists) {
            fileOperations.createIfNotExists();
        }
        if (!fileOperations.exists()) {
            fileExceptions.throwException("does not exist");
        }
        try {
            outputStream = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            fileExceptions.throwOperationException("open", e);
        }
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        isOpen = true;
    }

    public void writeln(Object text) {
        if (!isOpen) {
            fileExceptions.throwException("is not open");
        }
        try {
            writer.write(text.toString());
            writer.newLine();
        } catch (IOException e) {
            fileExceptions.throwOperationException("write", e);
        }
    }

    public ClosedFile close() {
        if (!isOpen) {
            fileExceptions.throwException("is already closed");
        }
        try {
            writer.flush();
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            fileExceptions.throwOperationException("open", e);
        }
        writer = null;
        outputStream = null;
        isOpen = false;

        return new ClosedFile(state, directory);
    }
}
