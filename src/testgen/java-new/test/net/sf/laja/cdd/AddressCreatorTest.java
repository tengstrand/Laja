package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Iterator;

import static net.sf.laja.cdd.AddressCreator.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreatorTest {

    @Test
    public void shouldBePossibleToCreateList() {
        ImmutableList<Address> addresses = createAddressList(addresses()).asAddressList();

        assertThat(addresses.get(0).isFromUppsala(), is(true));
        assertThat(addresses.get(1).isFromUppsala(), is(false));
    }

    @Test
    public void shouldBePossibleToCreateSet() {
        ImmutableSet<Address> addresses = createAddressSet(addresses()).asAddressSet();

        Iterator<Address> iterator = addresses.iterator();
        assertThat(iterator.next().isFromUppsala(), is(true));
        assertThat(iterator.next().isFromUppsala(), is(false));
    }

    @Test
    public void shouldBePossibleToCreateMap() {
        ImmutableMap<String,Address> map = createAddressMap(
                addressEntry("a", createAddress().streetName("First street").withCity("Uppsala")),
                addressEntry("b", createAddress().streetName("Second street").withCity("Stockholm"))
        ).asAddressMap();

        assertThat(map.get("a").isFromUppsala(), is(true));
        assertThat(map.get("b").isFromUppsala(), is(false));
    }

    private AddressCreator[] addresses() {
        return new AddressCreator[] {
                createAddress().streetName("First street").withCity("Uppsala"),
                createAddress().streetName("Second street").withCity("Stockholm") };
    }
}
