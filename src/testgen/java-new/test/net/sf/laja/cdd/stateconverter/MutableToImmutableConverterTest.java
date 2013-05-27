package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.IllegalPersonStateException;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.stateconverter.TypeConversion.asImmutable;
import static net.sf.laja.cdd.stateconverter.TypeConverters.toImmutable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MutableToImmutableConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asImmutable(null));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").birthday(2010,1,15).hairColor(1).children().defaults().asMutableState();
        PersonState state = (PersonState) toImmutable.convert(mutableState, 0);

        assertThat(state.name, equalTo("Carl"));
        assertThat(state.birthday, equalTo(new DateMidnight(2010,1,15)));
    }

    @Test(expected = IllegalPersonStateException.class)
    public void shouldThrowExceptionIfConvertingToInvalidImmutableState() {
        PersonMutableState mutableState = createPerson().name(null).birthday(2010,1,15).hairColor(1).children().defaults().asMutableState();
        toImmutable.convert(mutableState, 0);
    }

    @Test(expected = IllegalPersonStateException.class)
    public void shouldThrowExceptionIfConvertingListWithInvalidStateToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").birthday(2010,1,15).hairColor(1).children(
                createPerson().name(null).birthday(2011,1,1).hairColor(1).children().defaults()
        ).defaults().asMutableState();
        toImmutable.convert(mutableState, 0);
    }
}
