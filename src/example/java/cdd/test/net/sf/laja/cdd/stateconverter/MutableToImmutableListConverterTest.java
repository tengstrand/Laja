package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;
import net.sf.laja.cdd.state.AddressState;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static net.sf.laja.cdd.AddressCreator.*;
import static net.sf.laja.cdd.stateconverter.TypeConversion.asImmutableList;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toImmutable;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toImmutableList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MutableToImmutableListConverterTest {

    @Test
    public void shouldConvertFromMutableListOfIntegersToImmutableList() {
        List<Integer> mutableList = Arrays.asList(4, 1, 2, 3);
        ImmutableList immutableList = asImmutableList(mutableList);

        assertThat(immutableList, equalTo(ImmutableList.<Integer>builder().add(4, 1, 2, 3).build()));
    }

    @Test
    public void shouldConvertFromMutableListOfStateToImmutableStateList() {
        AddressListBuilder addresses = createAddressList(
                createAddress().streetName("First street"),
                createAddress().streetName("Second street")
        );
        ImmutableList<AddressState> immutableStates = asImmutableList(addresses.asMutableStateList(), toImmutable);

        assertThat(immutableStates, equalTo(addresses.asStateList()));
    }

    @Test
    public void shouldConvertFromMutableListOfMutableListOfIntegerToImmutableList() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(4, 5, 6);
        List<List<Integer>> mutableList = Arrays.asList(integers1, integers2);

        ImmutableList<ImmutableList<Integer>> immutableList = asImmutableList(mutableList, toImmutableList);

        ImmutableList<Integer> expected1 = ImmutableList.<Integer>builder().add(1, 2, 3).build();
        ImmutableList<Integer> expected2 = ImmutableList.<Integer>builder().add(4, 5, 6).build();
        ImmutableList<ImmutableList<Integer>> expectedList = ImmutableList.<ImmutableList<Integer>>builder().add(expected1, expected2).build();

        assertThat(immutableList, equalTo(expectedList));
    }
}
