package net.sf.laja.parser.cdd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readFiles(String fileOrDir, String endsWith) {
        List<String> files = new ArrayList<String>();
        templateFiles(new File(fileOrDir), endsWith, files);
        return files;
    }

    /**
     * Loop all directories and search for files that ends with the given 'endsWith',
     * e.g. State.java or Creator.java.
     *
     * @param fileOrDir a template file or a directory structure to search for state templates.
     * @param files put the template files in this list
     */
    private void templateFiles(File fileOrDir, String endsWith, List<String> files) {
        if (fileOrDir.isFile()) {
            String name = fileOrDir.getName();
            if (name.endsWith(endsWith) && name.length() > endsWith.length() && !name.startsWith(".")) {
                files.add(fileOrDir.getAbsolutePath());
            }
        } else {
            String[] children = fileOrDir.list();

            for (int i=0; i<children.length; i++) {
                templateFiles(new File(fileOrDir, children[i]), endsWith, files);
            }
        }
    }
}
