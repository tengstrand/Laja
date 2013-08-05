package net.sf.laja.cdd.validator;

import net.sf.laja.cdd.testgen.PersonCreator;
import net.sf.laja.cdd.testgen.state.PersonState;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static net.sf.laja.cdd.testgen.HairColor.BROWN;
import static net.sf.laja.cdd.testgen.PersonCreator.createPerson;
import static net.sf.laja.cdd.testgen.PersonCreator.createPersonList;
import static net.sf.laja.cdd.testgen.state.PersonState.PersonMutableState;
import static net.sf.laja.cdd.validator.Validators.collectionValidator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionValidatorTest {

    @Test
    public void validListOfPersonsShouldNotReturnValidationErrors() {
        List<PersonState.PersonMutableState> states = createPersonList(
                createPerson().name("Carl").hairColor(BROWN).children().defaults(),
                createPerson().name("Inga").hairColor(BROWN).children().defaults()
        ).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, states, "", "persons", errors, 0);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void invalidListOfPersonsShouldReturnValidationError() {
        PersonCreator person1 = createPerson().name(null).hairColor(BROWN).children().defaults();
        PersonCreator person2 = createPerson().name("Inga").hairColor(BROWN).children().defaults();

        List<PersonState.PersonMutableState> states = createPersonList(person1, person2).asMutableStateList();

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, states, "", "persons", errors, 0);

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(person1.asMutableState(), "name", "persons").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }

    @Test
    public void invalidListOfListOfPersonsShouldReturnValidationError() {
        PersonCreator person1 = createPerson().name(null).hairColor(BROWN).children().defaults();
        PersonCreator person2 = createPerson().name("Inga").hairColor(BROWN).children().defaults();

        List<PersonMutableState> states = createPersonList(person1, person2).asMutableStateList();

        List<List<PersonMutableState>> listOfStates = new ArrayList<List<PersonMutableState>>();
        listOfStates.add(states);

        ValidationErrors.Builder errors = ValidationErrors.builder();

        collectionValidator().validate(null, listOfStates, "", "persons", errors, 0, Validators.collectionValidator());

        ValidationErrors expectedErrors = ValidationErrors.builder()
                .addIsNullError(person1.asMutableState(), "name", "persons").build();

        assertThat(errors.build(), equalTo(expectedErrors));
    }

}
