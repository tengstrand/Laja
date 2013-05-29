package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.PersonCreator;
import net.sf.laja.cdd.ValidationErrors;
import net.sf.laja.cdd.state.PersonState;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.PersonCreator.createPerson;
import static net.sf.laja.cdd.PersonCreator.createPersonList;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionValidatorTest {

    @Test
    public void validListOfPersonsShouldNotReturnValidationErrors() {
        List<PersonState.PersonMutableState> states = createPersonList(
                createPerson().name("Carl").hairColor(1).children().defaults(),
                createPerson().name("Inga").hairColor(1).children().defaults()
        ).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, states, "", "persons", errors, new Validator[] {}, 0);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void invalidListOfPersonsShouldReturnValidationErrors() {
        PersonCreator person1 = createPerson().name(null).hairColor(1).children().defaults();
        PersonCreator person2 = createPerson().name("Inga").hairColor(1).children().defaults();

        List<PersonState.PersonMutableState> states = createPersonList(person1, person2).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, states, "", "persons", errors, new Validator[] {}, 0);

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(person1.asMutableState(), "persons", "name")
                .addIsNullError(person2.asMutableState(), "persons", "birthday").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }

    @Test
    public void invalidListOfListOfPersonsShouldReturnValidationErrors() {
        PersonCreator person1 = createPerson().name(null).hairColor(1).children().defaults();
        PersonCreator person2 = createPerson().name("Inga").hairColor(1).children().defaults();

        List<PersonMutableState> states = createPersonList(person1, person2).asMutableStateList();

        List<List<PersonMutableState>> listOfStates = new ArrayList<List<PersonMutableState>>();
        listOfStates.add(states);

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, listOfStates, "", "persons", errors, new Validator[] {}, 0, Validators.collectionValidator());

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(person1.asMutableState(), "persons", "name")
                .addIsNullError(person2.asMutableState(), "persons", "birthday").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }

}
