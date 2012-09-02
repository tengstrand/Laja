package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.statetemplate.StateTemplateErrors;

public class DirectoryConverter {

    public String convertSourceDirToOutputDir(String srcDir, String stateSrcDir, String stateOutDir, StateTemplateErrors errors) {
        srcDir = srcDir.replace("\\", "/");
        stateSrcDir = stateSrcDir.replace("\\", "/");
        stateOutDir = stateOutDir.replace("\\", "/");

        if (!srcDir.startsWith(stateSrcDir)) {
            errors.addMessage("The source path must begin with '" + srcDir + "' but was '" + stateSrcDir);
            return "---";
        }
        return stateOutDir + srcDir.substring(stateSrcDir.length());
    }

    /**
     * Calculates which directory a class belongs to. Example.
     * If sending in 'C:/Source/IDEA/CSB/src/main/java/csb' and 'csb.persistence.customer.CustomerInDb'
     * it will return 'C:/Source/IDEA/CSB/src/main/java/csb/persistence/customer'.
     *
     * @param directory
     * @param fullClassName
     * @return
     */
    public String asDirectory(String directory, String fullClassName) {
        String packageName = new StatementConverter().asPackageName(fullClassName);

        int index = packageName.indexOf(".");
        if (index < 0) {
            return directory;
        }
        String topDir = packageName.substring(0, index);

        if (directory.endsWith("/") || directory.endsWith("\\")) {
            directory = directory.substring(0, directory.length() - 1);
        }
        if (directory.endsWith("/" + topDir) || directory.endsWith("\\" + topDir)) {
            packageName = packageName.substring(index + 1);
        }

        for (String dir : packageName.split("\\.")) {
            directory += "/" + dir;
        }
        return  directory;
    }

    public String asDirectoryPath(String outDir, String packageName) {
        outDir = outDir.replace("\\", "/");
        if (!outDir.endsWith("/")) {
            outDir += "/";
        }
        return outDir + packageName.replaceAll("\\.", "/");
    }
}
