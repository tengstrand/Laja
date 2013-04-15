package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.PersonIntegrator;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PersonTest {

    @Test
    public void hasShortName() {
        assertTrue(PersonIntegrator.buildPerson().withName("Carl").asPerson().hasShortName());
    }

    @Test
    public void hasLongName() {
        assertFalse(PersonIntegrator.buildPerson().withName("Alexander").asPerson().hasShortName());
    }
}
