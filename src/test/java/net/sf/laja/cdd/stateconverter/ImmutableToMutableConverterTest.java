package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.testgen.HairColor;
import net.sf.laja.cdd.testgen.PersonCreator;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static net.sf.laja.cdd.stateconverter.StateConversion.asMutable;
import static net.sf.laja.cdd.testgen.PersonCreator.createPerson;
import static net.sf.laja.cdd.testgen.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImmutableToMutableConverterTest {

    @Test
    public void shouldConvertFromNullToNull() {
        assertNull(asMutable(null));
    }

    @Test
    public void shouldConvertFromImmutableToMutableState() {
        PersonCreator creator = createPerson().name("Carl").hairColor(HairColor.BLACK).children().defaults();
        PersonMutableState mutableState = (PersonMutableState) asMutable(creator.asState());

        assertThat(mutableState, equalTo(creator.asMutableState()));
    }
}
