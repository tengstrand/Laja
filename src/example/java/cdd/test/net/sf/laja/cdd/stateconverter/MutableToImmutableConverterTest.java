package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.stateconverter.TypeConversion.asImmutable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MutableToImmutableConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asImmutable(null));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        TypeConverter converter = new MutableToImmutableConverter();

        PersonMutableState mutableState = createPerson().name("Carl").birthday(2010,1,15).children().defaults().asMutableState();
        PersonState state = (PersonState)converter.convert(mutableState);

        assertThat(state.name, equalTo("Carl"));
        assertThat(state.birthday, equalTo(new DateMidnight(2010,1,15)));
    }
}
