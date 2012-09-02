package net.sf.laja.example.computer.behaviour;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ComputerTest {

    @Test
    public void standardAmiga() {
        Amiga amiga = AmigaFactory.owner("x").asAmiga(Configuration.STANDARD);

        assertFalse(amiga.hasFastFloatingPointUnit());
    }

    @Test
    public void fastAmiga() {
        Amiga amiga = AmigaFactory.owner("x").asAmiga(Configuration.FAST);

        assertTrue(amiga.hasFastFloatingPointUnit());
    }
}
