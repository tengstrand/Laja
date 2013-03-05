package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.Brow;
import org.junit.Test;

public class ChainedCreatorTest {

    @Test
    public void test() {
        Brow brow = Brow.area(10).asBrow();
    }
}
