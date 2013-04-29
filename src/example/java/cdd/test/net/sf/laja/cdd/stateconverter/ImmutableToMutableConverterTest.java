package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.junit.Test;

import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImmutableToMutableConverterTest {

    @Test
    public void shouldConvertFromImmutableToMutableState() {
        TypeConverter converter = new ImmutableToMutableConverter();

        PersonState state = createPerson().name("Carl").birthday(2010,1,15).children().defaultAddress().asState();
        PersonMutableState mutableState = (PersonMutableState)converter.convert(state);

        assertThat(mutableState.name, equalTo("Carl"));
        assertThat(mutableState.birthday, equalTo(new DateMidnight(2010,1,15)));
    }
}
