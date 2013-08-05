package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.state.converter.StateConverters.asMutableList;
import static net.sf.laja.cdd.state.converter.StateConverters.toMutable;
import static net.sf.laja.cdd.state.converter.StateConverters.toMutableList;
import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static net.sf.laja.cdd.testgen.state.AddressState.AddressMutableState;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImmutableToMutableListConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asMutableList(null));
    }

    @Test
    public void shouldConvertFromImmutableListOfIntegersToMutableList() {
        ImmutableList<Integer> immutableList = ImmutableList.of(4, 1, 2, 3);
        List<Integer> mutableList = asMutableList(immutableList);

        assertThat(mutableList, equalTo(Arrays.asList(4, 1, 2, 3)));
    }

    @Test
    public void shouldConvertFromImmutableListOfStateToMutableStateList() {
        AddressListBuilder addresses = createAddressList(
                createAddress().withStreetName("First street"),
                createAddress().withStreetName("Second street")
        );
        List<AddressMutableState> mutableStates = asMutableList(addresses.asStateList(), toMutable);

        assertThat(mutableStates, equalTo(addresses.asMutableStateList()));
    }

    @Test
    public void shouldConvertFromImmutableListOfImmutableListOfIntegerToMutableList() {
        ImmutableList<Integer> integers1 = ImmutableList.of(1, 2, 3);
        ImmutableList<Integer> integers2 = ImmutableList.of(4, 5, 6);

        ImmutableList<ImmutableList<Integer>> immutableList = ImmutableList.of(integers1, integers2);

        List<List<Integer>> mutableList = asMutableList(immutableList, toMutableList);

        List<Integer> expected1 = Arrays.asList(1, 2, 3);
        List<Integer> expected2 = Arrays.asList(4, 5, 6);

        assertThat(mutableList, equalTo(Arrays.asList(expected1, expected2)));
    }
}
