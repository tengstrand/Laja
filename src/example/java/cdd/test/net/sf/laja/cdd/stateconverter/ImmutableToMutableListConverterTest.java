package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.state.AddressState.AddressMutableState;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toMutable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImmutableToMutableListConverterTest {
    private TypeConverter converter;

    @Before
    public void setUp() {
        converter = new ImmutableToMutableListConverter();
    }

    @Test
    public void shouldConvertFromImmutableListOfIntegersToMutableList() {
        ImmutableList<Integer> integers = ImmutableList.<Integer>builder().add(5, 8, 1, 2, 3).build();
        List convertedIntegers = (List)converter.convert(integers);

        assertThat(convertedIntegers, equalTo(Arrays.asList(5, 8, 1, 2, 3)));
    }

    @Test
    public void shouldConvertFromImmutableListOfAddressStateToMutableStateList() {
        AddressListBuilder addresses = createAddressList(
                createAddress().streetName("First street"),
                createAddress().streetName("Second street")
        );
        List<AddressMutableState> convertedStates = (List<AddressMutableState>)converter.convert(addresses.asStateList(), toMutable);

        assertThat(convertedStates, equalTo(addresses.asMutableStateList()));
    }
}
