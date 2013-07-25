package net.sf.laja.example.file.text;

import net.sf.laja.example.file.Directory;
import net.sf.laja.example.file.FileExceptions;
import net.sf.laja.example.file.FileOperations;
import net.sf.laja.example.file.state.FileState;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.sf.laja.example.file.FileCreator.FileBehaviour;
import static net.sf.laja.example.file.text.TextDirectory.FILE;

public class TextFile extends FileBehaviour {
    private final FileOperations fileOperations;
    private final FileExceptions fileExceptions;

    public TextFile(FileState state, Directory directory) {
        super(state);

        fileOperations = new FileOperations(state, directory);
        fileExceptions = new FileExceptions(state, directory);
    }

    public void appendFile(String depth, StringBuilder builder) {
        builder.append("\n").append(FILE).append(depth).append(state.getFilename());
    }

    public List<String> readContent() {
        BufferedReader reader = createBufferedReader();

        List<String> lines = new ArrayList<String>();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throwException("read", e);
        }
        closeReader(reader);

        return lines;
    }

    private BufferedReader createBufferedReader() {
        try {
            String filename = fileOperations.getFilename();
            return  new BufferedReader(new java.io.FileReader(filename));
        } catch (FileNotFoundException e) {
            throwException("read", e);
            return null;
        }
    }

    private void closeReader(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throwException("close", e);
            }
        }
    }

    private void throwException(String operation, Exception e) {
        fileExceptions.throwOperationException(operation, e);
    }
}
