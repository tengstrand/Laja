package net.sf.laja.parser.cdd;

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
            files.put(filePath.replace("\\", "/"), status);
        }
        public void addRemove(String filePath) {
            files.put(filePath.replace("\\", "/"), REMOVE);
        }

        public void printProcessedMessage(Boolean verbose, Boolean autoRemove) {
            if (verbose == null) verbose = false;
            if (autoRemove == null) autoRemove = false;

            String message = "  Processed " + files.size() + " classes";

            if (verbose) {
                String directories = numberOfDirs == 1 ? "directory" : "directories";
                message += " (searched in " + numberOfDirs + " " + directories + ")";
            }
            message += ": " + count(NEW) + " new, " + count(CHANGED) + " changed, " +
                    count(UNCHANGED) + " unchanged";

            if (count(REMOVE) > 0) {
                if (autoRemove) {
                    message += ", " + count(REMOVE) + " was removed";
                } else {
                    message += ", " + count(REMOVE) + " to be manually removed";
                }
            }
            message += countNotUnchanged(autoRemove) > 0 ? ":" : ". Nothing new to generate.";
            System.out.println(message);

            List<String> fileStatuses = new ArrayList<String>();

            for (String filePath : files.keySet()) {
                String status = files.get(filePath);
                if (verbose || (!status.equals(UNCHANGED) && !status.equals(CHANGED))) {
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

        private int countNotUnchanged(boolean autoRemove) {
            int count = 0;
            for (String filePath : files.keySet()) {
                if (!files.get(filePath).equals(UNCHANGED)) {
                    count++;
                }
            }
            return count;
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
