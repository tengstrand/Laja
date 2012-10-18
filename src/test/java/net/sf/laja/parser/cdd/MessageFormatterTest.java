package net.sf.laja.parser.cdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class MessageFormatterTest {
    @Test
    public void testAsSortedTrimmedString() throws Exception {
        MessageFormatter formatter = new MessageFormatter();
        List<String> list = Arrays.asList("b", "a", "c");

        assertEquals("a, b, c", formatter.asSortedTrimmedString(list));
    }
}
