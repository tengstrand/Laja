package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.state.AddressState;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.example.AddressCreator.*;
import static net.sf.laja.cdd.stateconverter.StateConversion.asImmutableSet;
import static net.sf.laja.cdd.stateconverter.StateConverters.toImmutable;
import static net.sf.laja.cdd.stateconverter.StateConverters.toMutableSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MutableToImmutableSetConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asImmutableSet(null));
    }

    @Test
    public void shouldConvertFromMutableSetOfIntegersToImmutableSet() {
        Set<Integer> mutableSet = new HashSet(Arrays.asList(4, 1, 2, 3));
        ImmutableSet immutableSet = asImmutableSet(mutableSet);

        assertThat(immutableSet, equalTo(ImmutableSet.<Integer>builder().add(4, 1, 2, 3).build()));
    }

    @Test
    public void shouldConvertFromMutableSetOfStateToImmutableStateSet() {
        AddressSetBuilder addresses = createAddressSet(
                createAddress().withStreetName("First street"),
                createAddress().withStreetName("Second street")
        );
        ImmutableSet<AddressState> immutableStates = asImmutableSet(addresses.asMutableStateSet(), toImmutable);

        assertThat(immutableStates, equalTo(addresses.asStateSet()));
    }

    @Test
    public void shouldConvertFromMutableSetOfMutableSetOfIntegerToImmutableList() {
        Set<Integer> integers1 = new HashSet(Arrays.asList(1, 2, 3));
        Set<Integer> integers2 = new HashSet(Arrays.asList(4, 5, 6));
        Set<Set<Integer>> mutableSet = new HashSet(Arrays.asList(integers1, integers2));

        ImmutableSet<ImmutableSet<Integer>> immutableSet = asImmutableSet(mutableSet, toMutableSet);

        ImmutableSet<Integer> expected1 = ImmutableSet.<Integer>builder().add(1, 2, 3).build();
        ImmutableSet<Integer> expected2 = ImmutableSet.<Integer>builder().add(4, 5, 6).build();
        ImmutableSet<ImmutableSet<Integer>> expectedSet = ImmutableSet.<ImmutableSet<Integer>>builder().add(expected1, expected2).build();

        assertThat(immutableSet, equalTo(expectedSet));
    }
}
