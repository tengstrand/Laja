package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.PersonCreator;
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
                personEntry("a", createPerson().name("Carl").hairColor(1).children().defaults()),
                personEntry("b", createPerson().name("Anna").hairColor(1).children().defaults())
        ).asMutableStateMap();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        mapValidator().validate(null, states, "", "persons", errors, new Validator[] {}, 0);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void invalidMapOfPersonsShouldReturnValidationErrors() {
        PersonCreator person1 = createPerson().name("Carl").hairColor(1).children().defaults();
        PersonCreator person2 = createPerson().name(null).hairColor(1).children().defaults();

        Map<String,PersonMutableState> states = createPersonMap(
                personEntry("a", person1), personEntry("b", person2)).asMutableStateMap();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        mapValidator().validate(null, states, "", "persons", errors, new Validator[] {}, 0);

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(person2.asMutableState(), "persons", "name")
                .addIsNullError(person1.asMutableState(), "persons", "birthday").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }
}
