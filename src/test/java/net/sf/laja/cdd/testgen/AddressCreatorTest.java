package net.sf.laja.cdd.testgen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.testgen.state.AddressState;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreatorTest {

    // Context

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
        ImmutableMap<String,Address> map = addressMapBuilder().asAddressMap();

        assertThat(map.get("a").isFromUppsala(), is(true));
        assertThat(map.get("b").isFromUppsala(), is(false));
    }

    // State

    @Test
    public void shouldBePossibleToCreateStateList() {
        ImmutableList<AddressState> addresses = createAddressList(addresses()).asStateList();

        assertThat(addresses.get(0).city, equalTo("Uppsala"));
        assertThat(addresses.get(1).city, equalTo("Stockholm"));
    }

    @Test
    public void shouldBePossibleToCreateStateSet() {
        ImmutableSet<AddressState> addresses = createAddressSet(addresses()).asStateSet();

        Iterator<AddressState> iterator = addresses.iterator();
        assertThat(iterator.next().city, equalTo("Uppsala"));
        assertThat(iterator.next().city, equalTo("Stockholm"));
    }

    @Test
    public void shouldBePossibleToCreateStateMap() {
        ImmutableMap<String,AddressState> map = addressMapBuilder().asStateMap();

        assertThat(map.get("a").city, equalTo("Uppsala"));
        assertThat(map.get("b").city, equalTo("Stockholm"));
    }

    // MutableState

    @Test
    public void shouldBePossibleToCreateMutableStateList() {
        List<AddressState.AddressMutableState> addresses = createAddressList(addresses()).asMutableStateList();

        assertThat(addresses.get(0).city, equalTo("Uppsala"));
        assertThat(addresses.get(1).city, equalTo("Stockholm"));
    }

    @Test
    public void shouldBePossibleToCreateMutableStateSet() {
        Set<AddressState.AddressMutableState> addresses = createAddressSet(addresses()).asMutableStateSet();

        Iterator<AddressState.AddressMutableState> iterator = addresses.iterator();
        assertThat(iterator.next().city, equalTo("Uppsala"));
        assertThat(iterator.next().city, equalTo("Stockholm"));
    }

    @Test
    public void shouldBePossibleToCreateMutableStateMap() {
        Map<String,AddressState.AddressMutableState> map = addressMapBuilder().asMutableStateMap();

        assertThat(map.get("a").city, equalTo("Uppsala"));
        assertThat(map.get("b").city, equalTo("Stockholm"));
    }

    private AddressCreator[] addresses() {
        return new AddressCreator[] {
                createAddress().withId(1).withStreetName("First street").withCity("Uppsala"),
                createAddress().withId(2).withStreetName("Second street").withCity("Stockholm") };
    }

    private AddressMapBuilder addressMapBuilder() {
        return createAddressMap(
                createAddressEntry("a", createAddress().withId(1).withStreetName("First street").withCity("Uppsala")),
                createAddressEntry("b", createAddress().withId(2).withStreetName("Second street").withCity("Stockholm"))
        );
    }
}
