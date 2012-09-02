package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.fleck.Fleck;
import org.junit.Test;

public class FleckTest {

    @Test(expected = IllegalStateException.class)
    public void test() {
        Fleck.create().asFleck();
    }
}
