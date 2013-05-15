package net.sf.laja.parser.cdd.state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypeConverterTest {
    private TypeConverter converter;

    @Before
    public void setUp() {
        converter = new TypeConverter();
    }

    @Test
    public void convertString() {
        assertThat(converter.convert("String"), equalTo("String"));
    }

    @Test
    public void convertState() {
        assertThat(converter.convert("AddressState"), equalTo("AddressMutableState"));
    }

    @Test
    public void convertImmutableSet() {
        assertThat(converter.convert("ImmutableSet"), equalTo("Set"));
    }

    @Test
    public void convertImmutableList() {
        assertThat(converter.convert("ImmutableList"), equalTo("List"));
    }

    @Test
    public void convertImmutableMap() {
        assertThat(converter.convert("ImmutableMap"), equalTo("Map"));
    }
}
