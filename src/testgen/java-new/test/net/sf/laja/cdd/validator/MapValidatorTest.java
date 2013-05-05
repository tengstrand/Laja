package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.ValidationErrors;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.PersonCreator.*;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.validator.Validators.mapValidator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapValidatorTest {

    @Test
    public void validMapOfPersonsShouldNotReturnValidationErrors() {
        Map<String,PersonMutableState> states = createPersonMap(
                personEntry("a", createPerson().name("Carl").birthday(2011, 11, 11).children().defaults()),
                personEntry("b", createPerson().name("Anna").birthday(2012, 12, 12).children().defaults())
        ).asMutableStateMap();

        ValidationErrors.Builder errors = ValidationErrors.builder();
        mapValidator().validate(states, "", "persons", errors, 0);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void invalidMapOfPersonsShouldReturnValidationErrors() {
        Map<String,PersonMutableState> states = createPersonMap(
                personEntry("a", createPerson().name("Carl").birthday(null).children().defaults()),
                personEntry("b", createPerson().name(null).birthday(2012, 12, 12).children().defaults())
        ).asMutableStateMap();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        mapValidator().validate(states, "", "persons", errors, 0);

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError("persons", "name")
                .addIsNullError("persons", "birthday").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }
}
