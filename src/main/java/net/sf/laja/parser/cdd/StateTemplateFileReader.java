package net.sf.laja.parser.cdd;

import java.io.File;
import java.util.List;

public class StateTemplateFileReader {

    public void populateFiles(String fileOrDir, List<String> files) {
        templateFiles(new File(fileOrDir), files);
    }

    /**
     * Loop all directories and search for files that ends with 'StateTemplate.java'.
     *
     * @param fileOrDir a template file or a directory structure to search for state templates.
     * @param files put the template files in this list
     */
    private void templateFiles(File fileOrDir, List<String> files) {
        if (fileOrDir.isFile()) {
            final String templateName = "StateTemplate.java";
            String name = fileOrDir.getName();
            if (name.endsWith(templateName) && !name.startsWith(".") && name.length() > templateName.length()) {
                files.add(fileOrDir.getAbsolutePath());
            }
        } else {
            String[] children = fileOrDir.list();

            for (int i=0; i<children.length; i++) {
                templateFiles(new File(fileOrDir, children[i]), files);
            }
        }
    }
}
