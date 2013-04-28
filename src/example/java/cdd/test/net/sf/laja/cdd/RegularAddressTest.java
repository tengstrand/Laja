package net.sf.laja.cdd;

import org.junit.Test;

import static net.sf.laja.cdd.AddressCreator.createAddress;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegularAddressTest {

    @Test
    public void equalObjectsShouldMatch() throws Exception {
        Address address1 = createAddress().streetName("First street").asAddress();
        Address address2 = createAddress().streetName("First street").asAddress();

        assertThat(address1, equalTo(address2));
    }

    @Test
    public void addressIsFromUppsala() {
        Address address = createAddress().streetName("First street").withCity("Uppsala").asAddress();

        assertThat(address.isFromUppsala(), is(true));
    }

    @Test
    public void addressIsNotFromUppsala() {
        Address address = createAddress().streetName("First street").withCity("Stockholm").asAddress();

        assertThat(address.isFromUppsala(), is(false));
    }
}
