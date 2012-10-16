package net.sf.laja.parser.cdd;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputDirectoryReader {
    public static class Result {
        public int numberOfDirs;
        public Map<String,String> processedFiles = new LinkedHashMap<String,String>();

        private static String NEW = "NEW";
        private static String REMOVE = "REMOVE";
        private static String SKIP = "SKIP";
        private static String CHANGE = "CHANGED";

        public void add(String filePath, String status) {
            processedFiles.put(filePath.replace("\\", "/"), status);
        }
        public void addRemove(String filePath) {
            processedFiles.put(filePath.replace("\\", "/"), REMOVE);
        }

        public void printProcessedMessage() {
            String dirs = numberOfDirs == 1 ? "directory" : "directories";
            String message = "  Processed " + processedFiles.size() + " classes in " + numberOfDirs + " " + dirs + ": " +
                                count(NEW) + " new, " + count(CHANGE) + " changed, " +
                                count(SKIP) + " skipped";

            if (count(REMOVE) > 0) {
                message += ", " + count(REMOVE) + " to be manually removed";
            }
            if (countNotSkipped() == 0) {
                System.out.println(message + ". Nothing to generate.");
            } else {
                System.out.println(message + ":");
            }

            for (String filePath : processedFiles.keySet()) {
                String status = processedFiles.get(filePath);
                if (!status.equals(REMOVE)) {
                    status = status.toLowerCase();
                }
                if (!status.equals("skip") && !status.equals("changed")) {
                    System.out.println(StringUtils.rightPad("    (" + status.toLowerCase() + ")", 14) + filePath);
                }
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
                if (!processedFiles.get(filePath).equals(SKIP)) {
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
