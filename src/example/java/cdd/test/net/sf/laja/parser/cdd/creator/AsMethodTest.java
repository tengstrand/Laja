package net.sf.laja.parser.cdd.creator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AsMethodTest {
    @Test
    public void testGetStatementContent() throws Exception {
        AsMethod asMethod = new AsMethod();
        asMethod.setBody("{\n" +
                "    int x = 1;\n" +
                "    if (true) {\n" +
                "        // do something\n" +
                "    }\n" +
                "    return new Person(state.asImmutable());\n" +
                "    }");

        assertEquals(
                "        int x = 1;\n" +
                "        if (true) {\n" +
                "            // do something\n" +
                "        }\n" +
                "        return new Person(state.asImmutable());\n", asMethod.getTabbedBody("    "));
    }
}
