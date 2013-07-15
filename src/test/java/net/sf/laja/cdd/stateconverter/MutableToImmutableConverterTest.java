package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.state.PersonState;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.state.PersonState.InvalidPersonStateException;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.stateconverter.StateConversion.asImmutable;
import static net.sf.laja.cdd.stateconverter.StateConverters.toImmutable;
import static net.sf.laja.cdd.testgen.HairColor.BROWN;
import static net.sf.laja.cdd.testgen.PersonCreator.createPerson;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MutableToImmutableConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asImmutable(null));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").hairColor(BROWN).children().defaults().asMutableState();
        PersonState state = (PersonState) toImmutable.convert(mutableState, 0);

        assertThat(state.name, equalTo("Carl"));
    }

    @Test(expected = InvalidPersonStateException.class)
    public void shouldThrowExceptionIfConvertingToInvalidImmutableState() {
        PersonMutableState mutableState = createPerson().name(null).hairColor(BROWN).children().defaults().asMutableState();
        toImmutable.convert(mutableState, 0);
    }

    @Test(expected = InvalidPersonStateException.class)
    public void shouldThrowExceptionIfConvertingListWithInvalidStateToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").hairColor(BROWN).children(
                createPerson().name(null).hairColor(BROWN).children().defaults()
        ).defaults().asMutableState();
        toImmutable.convert(mutableState, 0);
    }
}
