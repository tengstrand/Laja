package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.state.PersonState;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.PersonCreator.createPersonList;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionValidatorTest {

    @Test
    public void validListOfPersonsShouldNotReturnValidationErrors() {
        List<PersonState.PersonMutableState> states = createPersonList(
                createPerson().name("Carl").birthday(2012, 12, 12).children().defaults(),
                createPerson().name("Inga").birthday(2011, 11, 11).children().defaults()
        ).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();
        collectionValidator().validate(states, "", "persons", errors, 0);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void invalidListOfPersonsShouldReturnValidationErrors() {
        List<PersonState.PersonMutableState> states = createPersonList(
                createPerson().name(null).birthday(2012, 12, 12).children().defaults(),
                createPerson().name("Inga").birthday(null).children().defaults()
        ).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();
        collectionValidator().validate(states, "", "persons", errors, 0);

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError("persons", "name")
                .addIsNullError("persons", "birthday").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }
}
