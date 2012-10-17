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
        public Map<String,String> processedFiles = new HashMap<String,String>();

        private static String NEW = "new";
        private static String REMOVE = "remove";
        private static String UNCHANGED = "unchanged";
        private static String CHANGED = "changed";

        public void add(String filePath, String status) {
            processedFiles.put(filePath.replace("\\", "/"), status);
        }
        public void addRemove(String filePath) {
            processedFiles.put(filePath.replace("\\", "/"), REMOVE);
        }

        public void printProcessedMessage(Boolean verbose) {
            if (verbose == null) verbose = false;

            String message = "  Processed " + processedFiles.size() + " classes";

            if (verbose) {
                String directories = numberOfDirs == 1 ? "directory" : "directories";
                message += " (searched in " + numberOfDirs + " " + directories + ")";
            }
            message += ": " + count(NEW) + " new, " + count(CHANGED) + " changed, " +
                    count(UNCHANGED) + " unchanged";

            if (count(REMOVE) > 0) {
                message += ", " + count(REMOVE) + " to be manually removed";
            }
            message += countNotSkipped() > 0 ? ":" : ". Nothing to generate.";
            System.out.println(message);

            List<String> fileStatuses = new ArrayList<String>();

            for (String filePath : processedFiles.keySet()) {
                String status = processedFiles.get(filePath);
                if (verbose || (!status.equals(UNCHANGED) && !status.equals(CHANGED))) {
                    fileStatuses.add(StringUtils.rightPad("    (" + status + ")", 16) + filePath);
                }
            }
            Collections.sort(fileStatuses);
            for (String fileStatus : fileStatuses) {
                System.out.println(fileStatus);
            }
        }

        private int count(String status) {
            int count = 0;
            for (String filePath : processedFiles.keySet()) {
                if (processedFiles.get(filePath).equals(status)) {
                    count++;
                }
            }
            return count;
        }

        private int countNotSkipped() {
            int count = 0;
            for (String filePath : processedFiles.keySet()) {
                if (!processedFiles.get(filePath).equals(UNCHANGED)) {
                    count++;
                }
            }
            return count;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "numberOfDirs=" + numberOfDirs +
                    ", number of processedFiles=" + processedFiles.size() +
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
