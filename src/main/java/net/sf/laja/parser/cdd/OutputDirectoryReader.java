package net.sf.laja.parser.cdd;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputDirectoryReader {
    public static class Result {
        public Map<String,String> files = new HashMap<String,String>();

        private static String CHANGED = "changed";
        private static String UNCHANGED = "unchanged";

        public void add(String filePath, String status) {
            filePath = FilenameUtils.normalize(filePath);
            files.put(filePath.replace("\\", "/"), status);
        }

        public void printProcessedMessage(Boolean verbose) {
            if (verbose == null) verbose = false;

            String message = "  Processed " + files.size() + " classes";

            String sep = ": ";

            int cntChanged = count(CHANGED);

            if (cntChanged > 0) { message += sep + cntChanged + " changed"; sep = ", "; }

            if (verbose) {
                int cntUnchanged = count(UNCHANGED);
                if (cntUnchanged > 0 && (cntChanged > 0)) { message += sep + cntUnchanged + " unchanged"; }
            }

            message += verbose ? ":" : existsOnlyUnchanged() ? ", no changes." : ".";
            System.out.println(message);

            List<String> fileStatuses = new ArrayList<String>();

            for (String filePath : files.keySet()) {
                String status = files.get(filePath);
                if (verbose) {
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
                    "number of files=" + files.size() +
                    '}';
        }
    }
}
