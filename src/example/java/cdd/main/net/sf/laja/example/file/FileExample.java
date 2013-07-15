package net.sf.laja.example.file;

import java.util.List;

import static net.sf.laja.example.file.DirectoryCreator.createDirectory;
import static net.sf.laja.example.file.FileCreator.createFile;

public class FileExample {

    /**
     * It is easy to get into a situation where a class has too much responsibility. A good example is the class
     * java.io.File. If the class java.io.Directory had existed, methods that were only relevant for Directory such as
     * mkdir() and listFiles() could have lived there and not in File.
     *
     * In these examples, we demonstrate how we can work with our directory structure in different contexts and tasks,
     * "ClosedFile", "WritableFile" and "TextFile". It would be easy to add more contexts, eg a context that produce HTML.
     */
    public static void main(String... args) {
        printDirectoryTree();

        ClosedFile closedFile = writeToFile();

        readTextFile(closedFile);
    }

    /**
     * We start by creating the variable 'directory' which initializes its catalogue structure.
     * Then we change behavior by calling method asTextDirectory() which gives us access to a new set of
     * methods tailored to the task, which in this case is to print the directory structure.
     *
     * Since the separation of state and behavior makes it easy to create new behavioral representations
     * it also encourages us to split our classes, making them smaller and easier to maintain,
     * which results in increased cohesion and facilitates the principle of Single responsibility.
     */
    private static void printDirectoryTree() {
        System.out.println("==== Print directory tree ====\n");

        final String baseDir = "./src/example/java/cdd/main/net/sf/laja/example/file/behaviour";
        if (!Directory.isDirectory(baseDir)) {
            System.out.println(baseDir + " is not a directory!");
            return;
        }
        Directory directory = createDirectory().directoryPath(baseDir).asDirectory();

        System.out.println(directory.asTextDirectory().directoryTree());
    }

    /**
     * Shows how the transition between different states can be made and that each state is managed by its own
     * behavior class. In this case a not yet opened file is handled by the class ClosedFile.
     * Before writing to a file we "change clothes" to fit the task "writing to file" by re-encapsulating
     * by calling asWritableFile() to get an instance of WritableFile. This will get us the methods writeln(String)
     * and close().
     */
    private static ClosedFile writeToFile() {
        System.out.println("\n==== Write to file ====\n");

        final String tempDirPath = "./target";
        final String tempFilename = "temp.txt";
        Directory.createDirectoryIfNotExists(tempDirPath);
        Directory tempDirectory = createDirectory().directoryPath(tempDirPath).asDirectory();

        WritableFile writableFile = createFile().filename(tempFilename).asWritableFile(tempDirectory, true);
        writableFile.writeln("Test writing to file");
        writableFile.writeln("row 2");
        ClosedFile closedFile = writableFile.close();

        System.out.println("Created file '" + tempFilename + "' in directory '" + tempDirPath + "'.");

        return closedFile;
    }

    /**
     * By switching to TextFile we get access to methods relevant when working with text files.
     */
    private static void readTextFile(ClosedFile closedFile) {
        System.out.println("\n==== Read text file  ====\n");

        List<String> linesInTextFile = closedFile.asTextFile().readContent();

        for (String line : linesInTextFile) {
            System.out.println(line);
        }
    }
}
