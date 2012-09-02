package net.sf.laja.parser.cdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectoryConverterTest {
    private DirectoryConverter converter = new DirectoryConverter();

    @Test
    public void convertSrcDirToOutDir() {
        final String srcDir      = "C:\\Source\\IDEA/Laja\\src\\test\\java\\net\\sf\\laja\\cdd\\state\\animal\\monster";
        final String stateSrcDir = "C:/Source/IDEA/Laja/src/test/java/net/sf/laja/cdd/state";
        final String stateOutDir = "C:/Source/IDEA/Laja/src/test/java/net/sf/laja/../../../../java-gen/net/sf/laja/cdd/state";

        String result = converter.convertSourceDirToOutputDir(srcDir, stateSrcDir, stateOutDir, null);

        assertEquals(stateOutDir + "/animal/monster", result);
    }

    @Test
    public void asDirectory() {
        String result = converter.asDirectory("C:/Source/IDEA/CSB/src/main/java/csb", "csb.persistence.customer.Customer");

        assertEquals("C:/Source/IDEA/CSB/src/main/java/csb/persistence/customer", result);
    }

    @Test
    public void asDirectoryPath() {
        String directoryPath = converter.asDirectoryPath("C:/Out", "a.b.c");
        assertEquals("C:/Out/a/b/c", directoryPath);
    }

    @Test
    public void asDirectoryPath_endsWithSlash() {
        String directoryPath = converter.asDirectoryPath("C:/Out/", "a");
        assertEquals("C:/Out/a", directoryPath);
    }
}
