package net.sf.laja.cdd.behaviour;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class AddressTest {

    @Test
    public void test() {
        Address address = AddressBuilder.build().withCity("Uppsala").asAddress();
        assertTrue(address.isFromUppsala());
    }
}
