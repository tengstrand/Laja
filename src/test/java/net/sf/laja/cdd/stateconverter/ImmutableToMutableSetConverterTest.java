package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.stateconverter.StateConversion.asMutableSet;
import static net.sf.laja.cdd.stateconverter.StateConverters.toMutable;
import static net.sf.laja.cdd.stateconverter.StateConverters.toMutableSet;
import static net.sf.laja.cdd.testgen.AddressCreator.*;
import static net.sf.laja.cdd.testgen.state.AddressState.AddressMutableState;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImmutableToMutableSetConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asMutableSet(null));
    }

    @Test
    public void shouldConvertFromImmutableSetOfIntegersToMutableSet() {
        ImmutableSet<Integer> immutableSet = ImmutableSet.<Integer>builder().add(4, 1, 2, 3).build();
        Set mutableSet = asMutableSet(immutableSet);

        Set expectedSet = new HashSet(Arrays.asList(4, 1, 2, 3));
        assertThat(mutableSet, equalTo(expectedSet));
    }

    @Test
    public void shouldConvertFromImmutableSetOfStateToMutableStateSet() {
        AddressSetBuilder addresses = createAddressSet(
                createAddress().withStreetName("First street"),
                createAddress().withStreetName("Second street")
        );
        Set<AddressMutableState> mutableStates = asMutableSet(addresses.asStateSet(), toMutable);

        assertThat(mutableStates, equalTo(addresses.asMutableStateSet()));
    }

    @Test
    public void shouldConvertFromImmutableSetOfImmutableSetOfIntegerToMutableSet() {
        ImmutableSet<Integer> integers1 = ImmutableSet.<Integer>builder().add(1, 2, 3).build();
        ImmutableSet<Integer> integers2 = ImmutableSet.<Integer>builder().add(4, 5, 6).build();

        ImmutableSet<ImmutableSet<Integer>> immutableSet = ImmutableSet.<ImmutableSet<Integer>>builder().add(integers1, integers2).build();

        Set mutableSet = asMutableSet(immutableSet, toMutableSet);

        Set<Integer> expected1 = new HashSet(Arrays.asList(1, 2, 3));
        Set<Integer> expected2 = new HashSet(Arrays.asList(4, 5, 6));

        Set expectedSet = new HashSet(Arrays.asList(expected1, expected2));
        assertThat(mutableSet, equalTo(expectedSet));
    }
}
