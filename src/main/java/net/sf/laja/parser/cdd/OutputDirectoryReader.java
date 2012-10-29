package net.sf.laja.parser.cdd;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputDirectoryReader {
    public static class Result {
        public int numberOfDirs;
        public Map<String,String> files = new HashMap<String,String>();

        private static String NEW = "new";
        private static String REMOVE = "remove";
        private static String UNCHANGED = "unchanged";
        private static String CHANGED = "changed";

        public void add(String filePath, String status) {
            filePath = FilenameUtils.normalize(filePath);
            files.put(filePath.replace("\\", "/"), status);
        }

        public void addRemove(String filePath) {
            add(filePath, REMOVE);
        }

        public void printProcessedMessage(Boolean verbose, boolean autoRemove) {
            if (verbose == null) verbose = false;

            String message = "  Processed " + files.size() + " classes";

            if (verbose) {
                String directories = numberOfDirs == 1 ? "directory" : "directories";
                message += " in " + numberOfDirs + " " + directories;
            }
            String sep = ": ";

            int cntNew = count(NEW);
            int cntChanged = count(CHANGED);
            int cntRemoved = count(REMOVE);

            if (cntNew > 0) { message += sep + cntNew + " new"; sep = ", "; }
            if (cntChanged > 0) { message += sep + cntChanged + " changed"; sep = ", "; }

            if (verbose) {
                int cntUnchanged = count(UNCHANGED);
                if (cntUnchanged > 0 && (cntNew > 0 || cntChanged > 0 || cntRemoved > 0)) { message += sep + cntUnchanged + " unchanged"; sep = ", "; }
            }

            if (cntRemoved > 0) {
                if (autoRemove) {
                    message += sep + count(REMOVE) + " removed";
                } else {
                    message += sep + count(REMOVE) + " to be manually removed";
                }
            }
            message += verbose ? ":" : existsOnlyUnchanged() ? ", no changes." : ".";
            System.out.println(message);

            List<String> fileStatuses = new ArrayList<String>();

            for (String filePath : files.keySet()) {
                String status = files.get(filePath);
                if (verbose || (!autoRemove && status.equals(REMOVE))) {
                    if (autoRemove && status.equals(REMOVE)) {
                        status = "removed";
                    }
                    fileStatuses.add(StringUtils.rightPad("    (" + status + ")", 16) + filePath);
                }
            }
            Collections.sort(fileStatuses);
            for (String fileStatus : fileStatuses) {
                System.out.println(fileStatus);
            }
        }

        public void removeFilesMarkedForDeletion() {
            for (String file : files.keySet()) {
                if (files.get(file).equals(REMOVE)) {
                    new File(file).delete();
                }
            }
        }

        private int count(String status) {
            int count = 0;
            for (String filePath : files.keySet()) {
                if (files.get(filePath).equals(status)) {
                    count++;
                }
            }
            return count;
        }

        private boolean existsOnlyUnchanged() {
            int unchangedCount = 0;

            for (String filePath : files.keySet()) {
                if (files.get(filePath).equals(UNCHANGED)) {
                    unchangedCount++;
                }
            }
            return unchangedCount > 0 && unchangedCount == files.keySet().size();
        }


        @Override
        public String toString() {
            return "Result{" +
                    "numberOfDirs=" + numberOfDirs +
                    ", number of files=" + files.size() +
                    '}';
        }
    }

    public void readFiles(String fileOrDir, Result result) {
        populate(new File(fileOrDir), result);
    }

    private void populate(File fileOrDir, Result result) {
        if (fileOrDir.isFile()) {
            String name = fileOrDir.getName();
            if (name.endsWith(".java") && !name.startsWith(".")) {
                result.addRemove(fileOrDir.getAbsolutePath());
            }
        } else {
            result.numberOfDirs++;
            String[] children = fileOrDir.list();

            for (int i=0; i<children.length; i++) {
                populate(new File(fileOrDir, children[i]), result);
            }
        }
    }
}
