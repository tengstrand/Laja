package net.sf.laja.parser.cdd;

import java.io.File;
import java.util.List;

public class BehaviourFileReader {

    public void populateFiles(String fileOrDir, List<String> files) {
        behaviourFiles(new File(fileOrDir), files);
    }

    public void behaviourFiles(File fileOrDir, List<String> files) {
        if (fileOrDir.isFile()) {
            String name = fileOrDir.getName();
            if (name.endsWith(".java") && !name.startsWith(".")) {
                files.add(fileOrDir.getAbsolutePath());
            }
        } else {
            String[] children = fileOrDir.list();

            for (int i=0; i<children.length; i++) {
                behaviourFiles(new File(fileOrDir, children[i]), files);
            }
        }
    }
}
