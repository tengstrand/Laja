package net.sf.laja.cdd.state;

import org.junit.Test;

import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonStateTest {

    @Test
    public void shouldConvertFromImmutableToMutableState() {
        PersonState state = createPerson().name("Carl").birthday(1977,8,15)
                .children(createPerson().name("Adam").birthday(2010,11,12).children().defaults())
                .defaults().asState();

        PersonMutableState mutableState = state.asMutable();

        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }

    @Test
    public void shouldConvertFromMutableToImmutableState() {
        PersonMutableState mutableState = createPerson().name("Carl").birthday(1977,8,15)
                .children(createPerson().name("Adam").birthday(2010,11,12).children().defaults())
                .defaults().asMutableState();

        PersonState state = mutableState.asImmutable();

        assertThat(mutableState.listOfSetOfMapOfIntegers.get(0).iterator().next().get("b"), equalTo(456));
    }
}
