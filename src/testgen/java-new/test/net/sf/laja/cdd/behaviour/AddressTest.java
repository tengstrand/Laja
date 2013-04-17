package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.Address;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.AddressCreator.buildAddress;

public class AddressTest {

    @Test
    public void test() {
        Address address = buildAddress().withCity("Uppsala").asAddress();
        assertTrue(address.isFromUppsala());
    }
}
