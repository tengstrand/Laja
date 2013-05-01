package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ValidationErrors;
import org.junit.Test;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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

    @Test
    public void shouldNotBeValidIfValidatingWithMissingAddress() {
        PersonMutableState state = buildPerson().withName("Carl").asMutableState();

        assertThat(state.isValid(), is(false));
    }

    @Test
    public void shouldReturn() {
        PersonMutableState state = buildPerson().withName("Carl").asMutableState();
        ValidationErrors errors = state.validate();

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError("birthday")
                .addIsNullError("address", "streetName").build();

        assertThat(errors, equalTo(expectedErrors));
    }
}
