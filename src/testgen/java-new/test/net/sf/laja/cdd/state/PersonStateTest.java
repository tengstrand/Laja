package net.sf.laja.cdd.state;

import net.sf.laja.cdd.ValidationErrors;
import org.junit.Test;

import java.util.Iterator;

import static net.sf.laja.cdd.PersonCreator.buildPerson;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.ValidationErrors.ValidationError;
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
    public void shouldCatchIsNullValidationErrors() {
        PersonMutableState state = buildPerson().withName("Carl").asMutableState();
        ValidationErrors errors = state.validate();

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError("birthday")
                .addIsNullError("address", "streetName").build();

        assertThat(errors, equalTo(expectedErrors));
    }

    @Test
    public void shouldCatchIsNullValidationErrorsInCollection() {
        PersonMutableState mutableState = createPerson().name(null).birthday(1988, 8, 8).children(
                createPerson().name(null).birthday(2010, 10, 10).children().defaults(),
                createPerson().name(null).birthday(2011, 11, 11).children().defaults()
        ).defaults().asMutableState();

        ValidationErrors errors = mutableState.validate();
        Iterator<ValidationError> iterator = errors.iterator();

        assertThat(errors.size(), is(2));
        assertThat(iterator.next(), equalTo(new ValidationError("name", "is_null")));
        assertThat(iterator.next(), equalTo(new ValidationError("children.name", "is_null")));
    }
}
