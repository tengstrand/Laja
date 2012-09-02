package net.sf.laja.parser.cdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BehaviourCreatorTest {
    private BehaviourCreator creator;

    @Before
    public void setUp() {
        creator = new BehaviourCreator();
    }

    @Test
    public void asBehaviourPackage() {
        String x = creator.asBehaviourPackage("net.sf.laja.cdd.state", "net.sf.laja.cdd.state.a.b", "net.sf.laja.cdd.behaviour");
        assertEquals("net.sf.laja.cdd.behaviour.a.b", x);
    }
}
