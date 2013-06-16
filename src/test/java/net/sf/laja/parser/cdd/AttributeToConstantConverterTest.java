package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.state.AttributeToConstantConverter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AttributeToConstantConverterTest {
    AttributeToConstantConverter converter;

    @Before
    public void setUp() {
        converter = new AttributeToConstantConverter();
    }

    @Test
    public void singleWordToConstant() {
        assertThat(converter.toConstant("abc"), equalTo("ABC"));
    }

    @Test
    public void sentenceToConstant() {
        assertThat(converter.toConstant("howAreYou"), equalTo("HOW_ARE_YOU"));
    }
}
