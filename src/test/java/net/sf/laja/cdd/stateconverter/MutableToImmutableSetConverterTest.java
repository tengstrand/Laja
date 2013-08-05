package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.testgen.state.AddressState;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.state.converter.StateConverters.*;
import static net.sf.laja.cdd.testgen.AddressCreator.*;
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
        ImmutableSet<Integer> immutableSet = asImmutableSet(mutableSet);

        assertThat(immutableSet, equalTo(ImmutableSet.of(4, 1, 2, 3)));
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

        ImmutableSet<Integer> expected1 = ImmutableSet.of(1, 2, 3);
        ImmutableSet<Integer> expected2 = ImmutableSet.of(4, 5, 6);
        ImmutableSet<ImmutableSet<Integer>> expectedSet = ImmutableSet.of(expected1, expected2);

        assertThat(immutableSet, equalTo(expectedSet));
    }
}
