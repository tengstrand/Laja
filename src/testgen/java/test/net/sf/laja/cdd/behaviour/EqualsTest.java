package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EqualsTest {
    private static final int AREA = 1;

    private BrowEncapsulator encapsulator() {
        return Brow.area(AREA);
    }

    private Brow behaviour() {
        return encapsulator().asBrow();
    }

    @Test
    public void behaviourEqualsEncapsulator() {
        assertEquals(behaviour(), encapsulator());
    }

    @Test
    public void encapsulatorEqualsBehaviour() {
        assertEquals(encapsulator(), behaviour());
    }
}
